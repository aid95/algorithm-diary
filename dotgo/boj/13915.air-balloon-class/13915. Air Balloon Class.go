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
	defer wr.Flush()

	var param [][]int
	for true {
		n := scanInt()
		tc := make([]int, n)
		for i := 0; i < n; i++ {
			tc = append(tc, scanInt())
		}
		param = append(param, tc)
	}

	answer := solution(param)
	for i := range answer {
		_, _ = wr.WriteString(strconv.Itoa(answer[i]))
	}
}

func solution(tc [][]int) []int {
	answer := make([]int, 0)
	for i := range tc {
		s := make(map[int]struct{})
		for j := range tc[i] {
			b := 0
			for t := tc[i][j]; 0 < t; t /= 10 {
				tt := t % 10
				b = b | (1 << tt)
			}
			s[b] = struct{}{}
		}
		answer = append(answer, len(s))
	}
	return answer
}
