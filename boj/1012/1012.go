package main

import (
	"bufio"
	"fmt"
	"os"
)

var in = bufio.NewScanner(os.Stdin)
var t, m, n, k int
var dir = [...][2]int{{0, 1}, {0, -1}, {-1, 0}, {1, 0}}
var farm, visit []int

const arrw int = 100
const arrh int = 100

func init() {
	farm = make([]int, arrw*arrh)
	visit = make([]int, arrw*arrh)

	in.Split(bufio.ScanWords)
}

func NextInt() int {
	r := 0

	in.Scan()
	for _, c := range in.Bytes() {
		r *= 10
		r += int(c - '0')
	}
	return r
}

func setXY(x, y, w, h int, arr []int, v int) {
	arr[y*w+x] = v
}

func getXY(x, y, w, h int, arr []int) int {
	return arr[y*w+x]
}

func clear(w, h int, arr []int) {
	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			arr[i*w+j] = 0
		}
	}
}

func bfs(x, y int) {
	setXY(x, y, m, n, visit, 1)

	for i := 0; i < 4; i++ {
		nx := x + dir[i][0]
		ny := y + dir[i][1]

		if (0 <= nx && nx < m) && (0 <= ny && ny < n) {
			if (getXY(nx, ny, m, n, visit) != 1) && (getXY(nx, ny, m, n, farm) == 1) {
				bfs(nx, ny)
			}
		}
	}
}

func main() {
	t = NextInt()
	ans := 0

	for i := 0; i < t; i++ {
		ans = 0
		m, n, k = NextInt(), NextInt(), NextInt()

		clear(arrw, arrh, farm)
		clear(arrw, arrh, visit)

		for j := 0; j < k; j++ {
			x, y := NextInt(), NextInt()
			setXY(x, y, m, n, farm, 1)
		}

		for k := 0; k < n; k++ {
			for l := 0; l < m; l++ {
				if getXY(l, k, m, n, visit) != 1 && getXY(l, k, m, n, farm) == 1 {
					bfs(l, k)
					ans++
				}
			}
		}

		fmt.Println(ans)
	}
}
