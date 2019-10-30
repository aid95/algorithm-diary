package main

import (
	"bufio"
	"os"
)

var scores [2][40]int
var N int

var in = bufio.NewScanner(os.Stdin)

func init() {
	in.Split(bufio.ScanWords)
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

func main() {
	N = NextInt()
	for j := 0; j < 2; j++ {
		for i := 0; i < N; i++ {
			scores[j][i] = NextInt()
		}
	}
}
