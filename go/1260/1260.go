package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

var in = bufio.NewScanner(os.Stdin)

var n, m, v int
var edge map[int][]int
var visit [1001]bool
var ans string
var q []int

func init() {
	in.Split(bufio.ScanWords)
	edge = make(map[int][]int)
	q = make([]int, 0)
}

func clearVisitArray() {
	for i := 0; i < 1001; i++ {
		visit[i] = false
	}
}

func NextInt() int {
	in.Scan()
	r := 0
	for _, c := range in.Bytes() {
		r *= 10
		r += int(c - '0')
	}
	return r
}

func dfs(start int) {
	visit[start] = true
	fmt.Printf("%d ", start)
	for _, n := range edge[start] {
		if !visit[n] {
			dfs(n)
		}
	}
}

func push(value int) {
	q = append(q, value)
}

func pop() int {
	r := q[0]
	q = q[1:]
	return r
}

func isEmpty() bool {
	if len(q) == 0 {
		return true
	}
	return false
}

func bfs(start int) {
	push(start)
	visit[start] = true
	for !isEmpty() {
		x := pop()
		fmt.Printf("%d ", x)
		for _, num := range edge[x] {
			if !visit[num] {
				visit[num] = true
				push(num)
			}
		}
	}
}

func main() {
	n, m, v = NextInt(), NextInt(), NextInt()

	for i := 0; i < m; i++ {
		s, d := NextInt(), NextInt()
		edge[s] = append(edge[s], d)
		edge[d] = append(edge[d], s)
	}

	for k, v := range edge {
		sort.Ints(v)
		fmt.Println(k, v)
	}

	clearVisitArray()
	dfs(v)
	fmt.Println()

	clearVisitArray()
	bfs(v)
	fmt.Println()
}
