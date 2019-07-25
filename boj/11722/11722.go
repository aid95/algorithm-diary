package main

import "fmt"

var N int
var A [1001]int
var dp [1001]int

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func main() {
	var result int = 0

	fmt.Scanln(&N)

	for i := 1; i <= N; i++ {
		fmt.Scan(&A[i])
	}

	for i := 1; i <= N; i++ {
		weight := 0
		for j := 1; j < i; j++ {
			if A[i] < A[j] {
				weight = max(weight, dp[j])
			}
		}
		dp[i] = weight + 1
		result = max(dp[i], result)
	}
	fmt.Println(result)
}