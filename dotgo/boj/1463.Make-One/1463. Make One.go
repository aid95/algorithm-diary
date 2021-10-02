package boj

func makeOne(N int) int {
	dp := make([]int, N+1)
	dp[0] = 0
	dp[1] = 1
	for i := 2; i <= N; i++ {
		dp[i] = dp[i-1] + 1
		if i%2 == 0 {
			dp[i] = min(dp[i/2]+1, dp[i])
		}
		if i%3 == 0 {
			dp[i] = min(dp[i/3]+1, dp[i])
		}
	}
	return dp[N]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
