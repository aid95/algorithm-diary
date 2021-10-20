package boj

import (
	"reflect"
	"testing"
)

func Test_solution(t *testing.T) {
	type args struct {
		tc [][]int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "testcase #1",
			args: args{[][]int{
				{132, 42, 3312, 43, 24424},
				{222, 22, 2},
			}},
			want: []int{3, 1},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := solution(tt.args.tc); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("solution() = %v, want %v", got, tt.want)
			}
		})
	}
}
