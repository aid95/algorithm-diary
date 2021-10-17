package boj

import (
	"bufio"
	"log"
	"os"
	"sort"
	"strconv"
)

var (
	sc *bufio.Scanner
	wr *bufio.Writer
)

func init() {
	sc = bufio.NewScanner(os.Stdin)
	sc.Split(bufio.ScanWords)

	wr = bufio.NewWriter(os.Stdout)
}

func scanInt() int {
	sc.Scan()
	ret, _ := strconv.Atoi(sc.Text())
	return ret
}

type Edge struct {
	from int
	to   int
	cost int
}

var root []int

func RunTC() {
	defer func(wr *bufio.Writer) {
		if err := wr.Flush(); err != nil {
			log.Fatal("Something was wrong...!!")

		}
	}(wr)

	N := scanInt()

	var graph []Edge
	for i := 1; i <= N; i++ {
		for j := 1; j <= N; j++ {
			c := scanInt()
			if i == j {
				continue
			}
			graph = append(graph, Edge{i, j, c})
		}
	}

	_, _ = wr.WriteString(strconv.Itoa(solution(N, graph)))
}

func find(x int) int {
	if x == root[x] {
		return x
	}
	root[x] = find(root[x])
	return root[x]
}

func solution(N int, graph []Edge) int {
	answer := 0

	sort.Slice(graph, func(l, r int) bool {
		return graph[l].cost < graph[r].cost
	})

	root = make([]int, N+1)
	for i := 0; i <= N; i++ {
		root[i] = i
	}

	for i := range graph {
		x := find(graph[i].from)
		y := find(graph[i].to)
		if x != y {
			answer += graph[i].cost
			root[x] = y
		}
	}

	return answer
}
