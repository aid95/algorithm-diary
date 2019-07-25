package main

import "fmt"

var dp [1001]int

/**
 * @brief
 * '1'이 나오는 횟수는 fibonacci의 결과와 동일하다.
 * '0'이 나오는 횟수는 해당 fibonacci number에서 -1한 결과와 같다.
 */
func fibo(x int) int {
	if x <= 1 {
		return dp[x]
	} else {
		if dp[x] > 0 {
			return dp[x]
		}
	}
	dp[x] = fibo(x-1) + fibo(x-2)
	return dp[x]
}

func main() {
	var t, n int

	fmt.Scanln(&t)
	for i := 0; i < t; i++ {
		dp[1], dp[2] = 1, 1
		fmt.Scanln(&n)
		if n == 0 {
			fmt.Println("1 0")
		} else if n == 1 {
			fmt.Println("0 1")
		} else {
			fibo(n)
			fmt.Printf("%d %d\n", dp[n-1], dp[n])
		}
	}
}
