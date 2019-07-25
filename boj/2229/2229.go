package main

import "fmt"
import "math"

var N int
var s [1001]int
var d [1001]int

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

/**
 * @brief 
 * 1, 2, 3일 경우 [3][2, 1], [3, 2][1], [3, 2, 1]로 검사하며 각 
 * 그룹의 합이 가장 큰 경우를 d배열에 담아 가져다닌다.
 * 
 * 최종적으로 전체적인 조의 잘짜임의 최대값을 출력한다.
 */
func main() {
	fmt.Scan(&N)
	for i := 1; i <= N; i++ {
		fmt.Scan(&s[i])

		var minValue int = math.MaxInt32
		var maxValue int = math.MinInt32
		for j := i; j > 0; j-- {
			minValue = min(minValue, s[j])
			maxValue = max(maxValue, s[j])

			d[i] = max(d[i], (maxValue-minValue)+d[j-1])
		}
	}
	fmt.Println(d[N])
}
