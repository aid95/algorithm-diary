package goorm

import (
	"reflect"
	"testing"
)

type question struct {
	para
	ans
}

type para struct {
	n int
}

type ans struct {
	r []int
}

func TestDivisor(t *testing.T) {
	qs := []question{
		{
			para{n: 20},
			ans{r: []int{1, 2, 4, 5, 10, 20}},
		},
	}
	for _, q := range qs {
		o := divisor(q.n)
		if reflect.DeepEqual(o, q.r) {
			t.Errorf("in [%v] out [%v]", q.r, o)
		}
	}
}
