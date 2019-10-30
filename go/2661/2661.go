package main

import (
	"bufio"
	"bytes"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var in = bufio.NewScanner(os.Stdin)
var n int
var buffer bytes.Buffer
var procbrk bool

func init() {
	in.Split(bufio.ScanWords)
	procbrk = false
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

func solve(l int, s string) {
	if procbrk {
		return
	}

	if len(s) >= l {
		procbrk = true
		fmt.Println(s)
	} else {
		for i := 1; i <= 3; i++ {
			if checkSeq(s + strconv.Itoa(i)) {
				solve(l, s+strconv.Itoa(i))
			}
		}
	}
}

func checkSeq(s string) bool {
	l := len(s)
	c := l / 2
	for i := 1; i <= c; i++ {
		k := i * 2
		for j := 0; (j + k) <= l; j++ {
			t1 := s[j : i+j]
			t2 := s[i+j : k+j]
			if strings.Compare(t1, t2) == 0 {
				return false
			}
		}
	}
	return true
}

func main() {
	n = NextInt()
	solve(n, "1")
}
