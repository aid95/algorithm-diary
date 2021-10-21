package boj

import (
	"bufio"
	"os"
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

func RunTC() {
	N := scanInt()
	scores := make([]int, 0)
	for i := 0; i < N; i++ {
		scores = append(scores, scanInt())
	}
	ans := solution(scores)
	_, _ = wr.WriteString(strconv.Itoa(ans))
}

func solution(scores []int) (cnt int) {
	n := len(scores)
	for i := n - 1 - 1; i >= 0; i-- {
		if scores[i+1] <= scores[i] {
			sub := scores[i] - scores[i+1] + 1
			scores[i] -= sub
			cnt += sub
		}
	}
	return
}
