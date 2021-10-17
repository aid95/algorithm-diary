package boj

import "testing"

func Test_solution(t *testing.T) {
	type args struct {
		N     int
		graph []Edge
	}
	tests := []struct {
		name string
		args args
		want int
	}{}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			solution(tt.args.N, tt.args.graph)
		})
	}
}
