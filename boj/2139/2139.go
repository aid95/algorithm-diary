package main

import "fmt"
import "time"

func Date(year, month, day int) time.Time {
	return time.Date(year, time.Month(month), day, 0, 0, 0, 0, time.UTC)
}

func main() {
	var day, month, year int

	for {
		fmt.Scan(&day)
		fmt.Scan(&month)
		fmt.Scan(&year)

		if year == 0 && month == 0 && day == 0 {
			break
		}

		baseDate := Date(year, 1, 1)
		endDate := Date(year, month, day)
		days := endDate.Sub(baseDate).Hours() / 24
		fmt.Println(days + 1)
	}
}