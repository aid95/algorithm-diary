package goorm

func mulOf3And5(n int) int {
	sum := 0
	for i := 3; i <= n; i++ {
		if i%3 == 0 || i%5 == 0 {
			sum += i
		}
	}
	return sum
}
