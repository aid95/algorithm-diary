package main

import (
	"fmt"
)

func max(nums ...float64) float64 {
	var r float64
	for _, num := range nums {
		if r < num {
			r = num
		}
	}
	return r
}

func main() {
	var a, b, c float64
	fmt.Scanf("%f %f %f", &a, &b, &c)
	fmt.Println(int64(max(a*b/c, a/b*c)))
}
