package main

import (
	"bufio"
	"fmt"
	"os"
)

var m, n int
var edge map[int][]int
var visit [1001]bool
var q []int

var in = bufio.NewScanner(os.Stdin)

func init() {
	in.Split(bufio.ScanWords)
	q = make([]int, 0)
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

func push(v int) {
	q = append(q, v)
}

func front() int {
	return q[0]
}

func pop() {
	q = q[1:]
}

func isEmpty() bool {
	if len(q) == 0 {
		return true
	}
	return false
}

func clearVisitArray() {
	for i := 0; i < 1001; i++ {
		visit[i] = false
	}
}

func bfs(s int) int {
	ans := 0
	visit[s] = true
	push(s)
	for !isEmpty() {
		x := front()
		pop()
		for _, c := range edge[x] {
			if !visit[c] {
				ans++
				visit[c] = true
				push(c)
			}
		}
	}
	return ans
}

func main() {
	testcase := NextInt()
	for i := 0; i < testcase; i++ {
		clearVisitArray()
		edge = make(map[int][]int)
		n, m = NextInt(), NextInt()
		for j := 0; j < m; j++ {
			x, y := NextInt(), NextInt()
			edge[x] = append(edge[x], y)
			edge[y] = append(edge[y], x)
		}
		fmt.Println(bfs(1))
	}
}
