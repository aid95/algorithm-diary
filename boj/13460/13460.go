package main

import "fmt"

var m, n int
var mapArr []rune
var rx, ry, bx, by int
var dir = [][]int{{0, 1}, {0, -1}, {-1, 0}, {1, 0}}

func bfs() int {
	// 방문한 위치를 표시한다.
	mapArr[ry*m+rx] = '#'

	// 현재 위치에서 이동가능한 방향을 찾는다.
	nd := 0
	for i := 0; i < 4; i++ {
		nx := rx + dir[i][0]
		ny := ry + dir[i][1]
		if mapArr[ny*m+nx] == '.' {
			nd = i
			break
		}
	}

	// 가능한 방향으로 공이 이동한다.
	for {
		mapArr[ry*m+rx] = '#'
		if mapArr[(ry+dir[nd][1])*m+(rx+dir[nd][0])] == '.' {
			ry += dir[nd][1]
			rx += dir[nd][0]
		} else if mapArr[ry*m+rx] == 'O' {
		}
	}
}

func main() {
	fmt.Scanf("%d %d", &m, &n)
	mapArr = make([]rune, (m+1)*(n+1))
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			fmt.Scanf("%c", &mapArr[i*m+j])
			if mapArr[i*m+j] == 'R' {
				rx = j
				ry = i
			} else if mapArr[i*m+j] == 'B' {
				bx = i
				by = j
			}
		}
	}
	fmt.Println(bfs())
}
