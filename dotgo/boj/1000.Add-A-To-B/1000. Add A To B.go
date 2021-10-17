package boj

import (
	"bufio"
	"fmt"
	"os"
)

func entry() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var a, b int
	_, _ = fmt.Fscanln(reader, &a, &b)
	_, _ = fmt.Fprintln(writer, addAtoB(a, b))
}

func addAtoB(a, b int) int {
	return a + b
}
