package goorm

func divisor(n int) (answer []int) {
	answer = make([]int, 0)
	for i := 1; i <= n; i++ {
		if n%i == 0 {
			answer = append(answer, i)
		}
	}
	return answer
}
