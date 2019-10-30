package main

import (
	"bufio"
	"os"
)

var in = bufio.NewScanner(os.Stdin)
var N, JM, HS int

func init() {
	in.Split(bufio.ScanWords)
}

func nextInt() int {
	in.Scan()
	r := 0
	for _, c := range in.Bytes() {
		r *= 10
		r += int(c - '0')
	}
	return r
}

func solve(newN int, ) {
	if newN % 2 == 0 {
		// 짝수
	}
	else {
		// 홀수
	}
}

func main() {
	N, JM, HS = nextInt(), nextInt(), nextInt()

}
