package goorm

import "testing"

type question struct {
	para
	ans
}

type para struct {
	n int
}

type ans struct {
	r int
}

func TestMulOf3And5(t *testing.T) {
	qs := []question{
		{
			para{n: 1000},
			ans{r: 234168},
		},
	}
	for _, q := range qs {
		o := mulOf3And5(q.n)
		if q.r != o {
			t.Errorf("in [%v] out [%v]", q.r, o)
		}
	}
}
