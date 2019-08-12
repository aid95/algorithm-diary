package main

import (
	"fmt"
)

var roomNumber string
var numberCountArray [11]int

func main() {
	fmt.Scan(&roomNumber)
	for _, num := range roomNumber {
		n := num - '0'
		numberCountArray[n]++
	}

	// 6, 9 처리
	numberCountArray[6] += numberCountArray[9]
	numberCountArray[9] = 0
	numberCountArray[6] = numberCountArray[6]/2 + numberCountArray[6]%2

	ans := 0
	for i := 0; i < 10; i++ {
		if ans < numberCountArray[i] {
			ans = numberCountArray[i]
		}
	}

	fmt.Println(ans)
}
