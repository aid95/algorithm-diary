package main

import "fmt"

func main() {
	var cnt [12]int
	var T, N int

	cnt[0] = 0
	cnt[1] = 1
	cnt[2] = 2
	cnt[3] = 4

	fmt.Scanln(&T)
	for i := 0; i < T; i++ {
		fmt.Scanln(&N)
		for j := 4; j <= N; j++ {
			cnt[j] = cnt[j-1] + cnt[j-2] + cnt[j-3]
		}
		fmt.Println(cnt[N])
	}
}
