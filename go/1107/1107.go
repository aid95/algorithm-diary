package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

var in = bufio.NewScanner(os.Stdin)

var channel int
var buttons = [...]bool{true, true, true, true, true, true, true, true, true, true}
var ans int

func init() {
	in.Split(bufio.ScanWords)
	ans = 987654321
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

func min(values ...int) int {
	tmp := math.MaxInt32
	for _, v := range values {
		if tmp > v {
			tmp = v
		}
	}
	return tmp
}

func join(strs ...string) string {
	var sb strings.Builder
	for _, str := range strs {
		sb.WriteString(str)
	}
	return sb.String()
}

func myAbs(value int) int {
	if value < 0 {
		return -value
	}
	return value
}

func solve(number string) {
	for i := 0; i < 10; i++ {
		if buttons[i] {
			newNumber := join(number, strconv.Itoa(i))
			n, _ := strconv.Atoi(newNumber)
			ans = min(ans, myAbs(channel-n)+len(newNumber))

			if len(newNumber) < 6 {
				solve(newNumber)
			}
		}
	}
}

func main() {
	channel = NextInt()
	ans = min(ans, myAbs(100-channel))

	n := NextInt()
	for i := 0; i < n; i++ {
		tmp := NextInt()
		buttons[tmp] = false
	}

	solve("")
	fmt.Println(ans)
}
