package main

import (
	"fmt"
	"sort"
	"strings"
)

var numbers string

type SortBy []int

func (a SortBy) Len() int           { return len(a) }
func (a SortBy) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a SortBy) Less(i, j int) bool { return a[i] > a[j] }

func main() {
	fmt.Scan(&numbers)
	var s []int
	for _, dig := range numbers {
		s = append(s, int(dig)-int('0'))
	}
	sort.Sort(SortBy(s))
	fmt.Print(strings.Trim(strings.Replace(fmt.Sprint(s), " ", "", -1), "[]"))
}
