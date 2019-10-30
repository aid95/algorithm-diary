package main

import "fmt"

var mat [1001][1001]int
var m, n, ans int
var visit [1001][1001]bool

type Queue struct {
	nodes [][]int
}

func (q *Queue) push(x, yint) {
	q.nodes = append(q.nodes, []int{x, y})
}

func (q *Queue) pop() {
	q.nodes = q.nodes[1:]
}

func (q *Queue) front() (int, int) {
	return q.nodes[0][0], q.nodes[0][1]
}

func (q *Queue) empty() bool {
	if len(q.nodes) == 0 {
		return true
	} else {
		return false
	}
}

func init() {
	ans = 987654321
}

func min(a ...int) int {
	r := 987654321
	for _, c := range a {
		if r > c {
			r = c
		}
	}
	return r
}

func bfs(x, y int) {
	visit[y][x] = true
	q.push(x, y)
	for !q.empty() {
		ans = min(ans, 0)
	}
}

func clearInfo() {
	for i := 0; i < 1001; i++ {
		for j := 0; j < 1001; j++ {
			visit[i][j] = false
			mat[i][j] = 0
		}
	}
}

func main() {
	fmt.Scanf("%d %d", &m, &n)
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			fmt.Scanf("%d", &mat[i][j])
		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			bfs(i, j)
		}
	}
}
