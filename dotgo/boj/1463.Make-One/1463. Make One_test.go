package boj

import (
	"fmt"
	"testing"
)

type question1 struct {
	para1
	ans1
}

type para1 struct {
	num int
}

type ans1 struct {
	num int
}

func TestMakeOne(t *testing.T) {
	qs := []question1{
		{
			para1{num: 3},
			ans1{num: 1},
		},
		{
			para1{num: 10},
			ans1{num: 3},
		},
	}

	for _, q := range qs {
		ans := q.ans1.num
		i := q.para1.num
		o := makeOne(i)
		if ans == o {
			t.Errorf("Input value : %v\nOutput value : %v\nExpected value: %v\n\n", i, o, ans)
		}
	}
	fmt.Println()
}
