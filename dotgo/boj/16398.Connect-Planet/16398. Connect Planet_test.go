package boj

import "testing"

func matrixToGraph(matrix [][]int) []Edge {
	var graph []Edge
	N := len(matrix[0])
	for i := 1; i <= N; i++ {
		for j := 1; j <= N; j++ {
			if i == j {
				continue
			}
			graph = append(graph, Edge{i, j, matrix[i-1][j-1]})
		}
	}
	return graph
}

func Test_solution(t *testing.T) {
	type args struct {
		n     int
		graph []Edge
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "testcase #1", args: args{n: 3, graph: matrixToGraph(
			[][]int{
				{0, 2, 3},
				{2, 0, 1},
				{3, 1, 0},
			})}, want: 3},
		{name: "testcase #2", args: args{n: 5, graph: matrixToGraph(
			[][]int{
				{0, 6, 8, 1, 3},
				{6, 0, 5, 7, 3},
				{8, 5, 0, 9, 4},
				{1, 7, 9, 0, 6},
				{3, 3, 4, 6, 0},
			})}, want: 11},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := solution(tt.args.n, tt.args.graph); got != tt.want {
				t.Errorf("solution() = %v, want %v", got, tt.want)
			}
		})
	}
}
