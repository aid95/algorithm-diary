package main

import "fmt"

var dp [1001]int

func fibo(x int) int {
	if x < 1001 {
		if dp[x] != 0 {
			return dp[x]
		}
	}

	if x == 0 {
		return 0
	} else if x == 1 {
		return 1
	} else {
		dp[x] = fibo(x-1) + fibo(x-2)
		return dp[x]
	}
}

func main() {
	var n int

	fmt.Scanln(&n)
	fmt.Println(fibo(n))
}
