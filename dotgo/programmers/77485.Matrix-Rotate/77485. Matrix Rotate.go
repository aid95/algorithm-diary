package programmers

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func solution(rows int, columns int, queries [][]int) []int {
	mat := make([][]int, rows)
	n := 1
	for i := 0; i < rows; i++ {
		mat[i] = make([]int, columns)
		for j := 0; j < columns; j++ {
			mat[i][j] = n
			n++
		}
	}

	ans := make([]int, 0)
	for _, arr := range queries {
		top, left, bottom, right := arr[0]-1, arr[1]-1, arr[2]-1, arr[3]-1

		tmp := mat[top][left]

		for i := top; i < bottom; i++ {
			tmp = min(tmp, mat[i+1][left])
			mat[i][left], mat[i+1][left] = mat[i+1][left], mat[i][left]
		}

		for i := left; i < right; i++ {
			tmp = min(tmp, mat[bottom][i+1])
			mat[bottom][i], mat[bottom][i+1] = mat[bottom][i+1], mat[bottom][i]
		}

		for i := bottom; i > top; i-- {
			tmp = min(tmp, mat[i-1][right])
			mat[i][right], mat[i-1][right] = mat[i-1][right], mat[i][right]
		}

		for i := right; i > left+1; i-- {
			tmp = min(tmp, mat[top][i-1])
			mat[top][i], mat[top][i-1] = mat[top][i-1], mat[top][i]
		}

		ans = append(ans, tmp)
	}

	return ans
}
