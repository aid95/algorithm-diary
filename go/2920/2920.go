package main

import (
	"bufio"
	"fmt"
	"os"
)

var node [8]int
var n int

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

func check() string {
	for i := 0; i < 8-1; i++ {
		if node[i] < node[i+1] {
			n++
		} else if node[i] > node[i+1] {
			n--
		} else {
			break
		}
	}

	if n == 7 {
		return "ascending"
	} else if n == -7 {
		return "descending"
	} else {
		return "mixed"
	}
}

func main() {
	for i := 0; i < 8; i++ {
		node[i] = NextInt()
	}
	fmt.Println(check())
}
