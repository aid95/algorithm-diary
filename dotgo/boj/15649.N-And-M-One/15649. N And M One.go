package boj

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

var sc = bufio.NewScanner(os.Stdin)
var wr = bufio.NewWriter(os.Stdout)

var visited []bool
var seq []int
var m, n int

func scanInt() int {
	sc.Scan()
	m := 1
	n := 0
	for _, b := range sc.Bytes() {
		if b == '-' {
			m = -1
		} else {
			n = 10*n + int(b-'0')
		}
	}
	return n * m
}

func bk(num, cnt int) {
	if cnt == n {
		ans := strings.Trim(strings.Join(strings.Fields(fmt.Sprint(seq)), " "), "[]")
		_, _ = wr.WriteString(ans)
		return
	}
	for i := num; i <= m; i++ {
		if !visited[i] {
			visited[i] = true
			seq[cnt] = i
			bk(i+1, cnt+1)
			visited[i] = false
		}
	}
}

func nmOne() {
	n = scanInt()
	m = scanInt()

	visited = make([]bool, m+1)
	seq = make([]int, n)
	bk(1, 0)

	_ = wr.Flush()
}
