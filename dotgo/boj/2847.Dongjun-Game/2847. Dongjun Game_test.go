package boj

import "testing"

func Test_solution(t *testing.T) {
	type args struct {
		scores []int
	}
	tests := []struct {
		name    string
		args    args
		wantCnt int
	}{
		{
			name:    "testcase #1",
			args:    args{scores: []int{5, 5, 5}},
			wantCnt: 3,
		},
		{
			name:    "testcase #2",
			args:    args{scores: []int{5, 3, 7, 5}},
			wantCnt: 6,
		},
		{
			name:    "testcase #3",
			args:    args{scores: []int{6, 5, 4, 8}},
			wantCnt: 6,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotCnt := solution(tt.args.scores); gotCnt != tt.wantCnt {
				t.Errorf("solution() = %v, want %v", gotCnt, tt.wantCnt)
			}
		})
	}
}
