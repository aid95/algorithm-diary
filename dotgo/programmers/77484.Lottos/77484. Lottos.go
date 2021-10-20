package programmers

func filter(arr []int, t int) []int {
	ret := make([]int, 0)
	for _, v := range arr {
		if v != t {
			ret = append(ret, v)
		}
	}
	return ret
}

func contains(a []int, v int) bool {
	for _, vv := range a {
		if vv == v {
			return true
		}
	}
	return false
}

func convRank(hit int) int {
	if hit < 2 {
		return 6
	}
	return 7 - hit
}

func solution(lottos []int, win_nums []int) []int {
	ol := len(lottos)
	lottos = filter(lottos, 0)
	nl := len(lottos)

	hit := 0
	for _, v := range lottos {
		if contains(win_nums, v) {
			hit += 1
		}
	}

	return []int{convRank(hit + (ol - nl)), convRank(hit)}
}
