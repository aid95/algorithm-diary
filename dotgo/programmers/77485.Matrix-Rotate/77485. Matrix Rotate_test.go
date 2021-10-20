package programmers

import (
	"reflect"
	"testing"
)

func Test_solution(t *testing.T) {
	type args struct {
		rows    int
		columns int
		queries [][]int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "testcase #1",
			args: args{
				rows:    6,
				columns: 6,
				queries: [][]int{
					{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3},
				},
			},
			want: []int{8, 10, 25},
		},
		{
			name: "testcase #2",
			args: args{
				rows:    3,
				columns: 3,
				queries: [][]int{
					{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3},
				},
			},
			want: []int{1, 1, 5, 3},
		},
		{
			name: "testcase #3",
			args: args{
				rows:    100,
				columns: 97,
				queries: [][]int{
					{1, 1, 100, 97},
				},
			},
			want: []int{1},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := solution(tt.args.rows, tt.args.columns, tt.args.queries); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("solution() = %v, want %v", got, tt.want)
			}
		})
	}
}
