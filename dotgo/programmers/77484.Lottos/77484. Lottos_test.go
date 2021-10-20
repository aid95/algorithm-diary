package programmers

import (
	"reflect"
	"testing"
)

func Test_solution(t *testing.T) {
	type args struct {
		lottos   []int
		win_nums []int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "testcase #1",
			args: args{
				lottos:   []int{44, 1, 0, 0, 31, 25},
				win_nums: []int{31, 10, 45, 1, 6, 19},
			},
			want: []int{3, 5},
		},
		{
			name: "testcase #1",
			args: args{
				lottos:   []int{0, 0, 0, 0, 0, 0},
				win_nums: []int{38, 19, 20, 40, 15, 25},
			},
			want: []int{1, 6},
		},
		{
			name: "testcase #1",
			args: args{
				lottos:   []int{45, 4, 35, 20, 3, 9},
				win_nums: []int{20, 9, 3, 45, 4, 35},
			},
			want: []int{1, 1},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := solution(tt.args.lottos, tt.args.win_nums); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("solution() = %v, want %v", got, tt.want)
			}
		})
	}
}
