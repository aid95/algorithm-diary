package goorm

func perfectNumber(a, b int) []int {
	var answers []int
	for i := a; i <= b; i++ {
		dvs := getDivisor(i)
		dvs = dvs[:len(dvs)-1]
		if i == sum(dvs) {
			answers = append(answers, i)
		}
	}
	return answers
}

func getDivisor(n int) (dvs []int) {
	for i := 1; i <= n; i++ {
		if n%i == 0 {
			dvs = append(dvs, i)
		}
	}
	return
}

func sum(arr []int) int {
	r := 0
	for _, i := range arr {
		r += i
	}
	return r
}
