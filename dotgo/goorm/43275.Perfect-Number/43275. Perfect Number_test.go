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
	a, b int
}

type ans struct {
	n []int
}

func TestPerfectNumber(t *testing.T) {
	qs := []question{
		{
			para{
				a: 1,
				b: 100,
			},
			ans{

				n: []int{6, 28},
			},
		},
		{
			para{
				a: 10,
				b: 1000,
			},
			ans{

				n: []int{28, 496},
			},
		},
	}
	for _, q := range qs {
		r := perfectNumber(q.a, q.b)
		if reflect.DeepEqual(r, q.ans) {
			t.Errorf("wrong")
		}
	}
}
