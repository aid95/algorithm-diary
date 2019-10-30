package main

import "fmt"

var seq string
var m []int

func init() {
	m = []int{
		3, 3, 3,
		4, 4, 4,
		5, 5, 5,
		6, 6, 6,
		7, 7, 7,
		8, 8, 8, 8,
		9, 9, 9,
		10, 10, 10, 10}
}

func main() {
	var s string
	fmt.Scanf("%s", &s)
	sum := 0
	for _, c := range s {
		sum += m[c-'A']
	}
	fmt.Println(sum)
}
