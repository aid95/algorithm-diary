package main

import "fmt"

var N int
var arr [10001]int
var w [10001]int

func MAX(nums ...int) int {
	var max int = 0
	for _, v := range nums {
		if max < v {
			max = v
		}
	}
	return max
}

func main() {
	fmt.Scanln(&N)
	for i := 1; i <= N; i++ {
		fmt.Scanln(&arr[i])
	}
	w[1] = arr[1]
	for i := 2; i <= N; i++ {
		w[i] = arr[i] + arr[i-1]
	}
	for i := 3; i <= N; i++ {
		res := 0
		res = MAX(arr[i]+w[i-2], w[i-1])
		res = MAX(res, arr[i]+arr[i-1]+w[i-3])
		w[i] = res
	}
	fmt.Println(w[N])
	return
}
