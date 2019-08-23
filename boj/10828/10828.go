package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Stack struct {
	nodes []int
}

func (s *Stack) push(v int) {
	s.nodes = append(s.nodes, v)
}

func (s *Stack) pop() int {
	if s.size() == 0 {
		return -1
	}
	r := s.nodes[s.size()-1]
	s.nodes = s.nodes[:s.size()-1]
	return r
}

func (s *Stack) size() int {
	return len(s.nodes)
}

func (s *Stack) empty() bool {
	if s.size() == 0 {
		return true
	}
	return false
}

func (s *Stack) top() int {
	if s.size() == 0 {
		return -1
	}
	return s.nodes[s.size()-1]
}

func main() {
	var cmdCount int
	fmt.Scanf("%d", &cmdCount)
	scanner := bufio.NewScanner(os.Stdin)

	s := &Stack{}
	for i := 0; i < cmdCount; i++ {
		scanner.Scan()
		command := scanner.Text()
		arr := strings.Split(command, " ")
		switch arr[0] {
		case "push":
			num, _ := strconv.Atoi(arr[1])
			s.push(num)
		case "pop":
			fmt.Println(s.pop())
		case "size":
			fmt.Println(s.size())
		case "empty":
			if s.empty() {
				fmt.Println("1")
			} else {
				fmt.Println("0")
			}
		case "top":
			fmt.Println(s.top())
		}
	}
}
