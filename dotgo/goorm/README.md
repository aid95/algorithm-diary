# Go

## Template code

```go
package main

import (
	"bufio"
	"os"
	// "strconv"
	// "fmt"
	"strings"
)

func main() {
	stdin := bufio.NewReader(os.Stdin)
	stdout := bufio.NewWriter(os.Stdout)

	rl, _, _ := stdin.ReadLine()
	v := strings.Split(string(rl), " ")

	for _, token := range v {
		stdout.WriteString(token)
	}

	stdout.Flush()
}
```
