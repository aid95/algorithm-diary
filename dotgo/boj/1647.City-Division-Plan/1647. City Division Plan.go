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
	src, des, cost int
}

var root []int

func RunTC() {
	N := scanInt()
	M := scanInt()

	var graph []Edge
	for i := 0; i < M; i++ {
		a, b, c := scanInt(), scanInt(), scanInt()
		graph = append(graph, Edge{a, b, c})
	}

	_, _ = wr.WriteString(strconv.Itoa(solution(N, graph)))
}

func find(x int) int {
	if root[x] == x {
		return x
	}
	root[x] = find(root[x])
	return root[x]
}

func solution(N int, graph []Edge) int {
	defer func(wr *bufio.Writer) {
		if err := wr.Flush(); err != nil {
			log.Fatal("something was wrong...")
		}
	}(wr)

	sort.Slice(graph, func(i, j int) bool {
		return graph[i].cost < graph[j].cost
	})

	root = make([]int, N+1)
	for i := 1; i <= N; i++ {
		root[i] = i
	}

	var sum []int
	for i := range graph {
		x := find(graph[i].src)
		y := find(graph[i].des)
		if x != y {
			sum = append(sum, graph[i].cost)
			root[x] = y // union
		}
	}
	sum = sum[:len(sum)-1]
	ans := 0
	for i := range sum {
		ans += sum[i]
	}

	return ans
}
