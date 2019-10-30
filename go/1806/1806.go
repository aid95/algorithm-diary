package main

import "bufio"
import "fmt"
import "math"
import "os"

func main() {
	var N, S int
	fmt.Scanf("%d %d", &N, &S)

	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)
	var arr []int = make([]int, N+1)
	for i := 0; i < N; i++ {
		scanner.Scan()
		r := 0
		for _, c := range scanner.Bytes() {
			r *= 10
			r += int(c - '0')
		}
		arr[i] = r
	}

	min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}

	var sum, l, r, m int = arr[0], 0, 0, math.MaxInt32
	for l <= r && r < N {
		if sum >= S {
			m = min(m, r-l+1)
			// 움기기 전에 빼기
			sum -= arr[l]
			l += 1
		} else if sum < S {
			// 움긴 후에 더하기
			r += 1
			sum += arr[r]
		}
	}

	if m == math.MaxInt32 {
		fmt.Println(0)
	} else {
		fmt.Println(m)
	}
}
