package main

import (
	"fmt"
	"sort"
)

var n int
var p []int

func main() {
	fmt.Scanf("%d", &n)
	p = make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scanf("%d", &p[i])
	}

	ans := 0
	sort.Ints(p)
	fmt.Println(p)
	for i := 0; i < n; i++ {
		t := 0
		for j := 0; j <= i; j++ {
			t += p[j]
		}
		ans += t
	}

	fmt.Println(ans)
}
