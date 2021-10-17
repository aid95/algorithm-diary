package boj

import (
	"bytes"
	"io/ioutil"
	"log"
	"os"
	"testing"
)

func captureOutput(fn func()) string {
	var buf bytes.Buffer
	log.SetOutput(&buf)
	fn()
	log.SetOutput(os.Stderr)
	return buf.String()
}

func runTC(inputData []byte, solver func()) string {
	tmpTCInputFile, err := ioutil.TempFile("", "tc_in")
	if err != nil {
		log.Fatal(err)
	}
	defer func(name string) {
		err := os.Remove(name)
		if err != nil {
			log.Fatal(err)
		}
	}(tmpTCInputFile.Name())

	if _, err := tmpTCInputFile.Write(inputData); err != nil {
		log.Fatal(err)
	}

	if _, err := tmpTCInputFile.Seek(0, 0); err != nil {
		log.Fatal(err)
	}

	oldStdin := os.Stdin
	defer func() { os.Stdin = oldStdin }()
	os.Stdin = tmpTCInputFile

	output := captureOutput(solver)

	_ = tmpTCInputFile.Close()

	return output
}

func Test_entry(t *testing.T) {
	tests := []struct {
		description string
		tc          []byte
		ac          string
	}{
		{"1 + 2", []byte("1 2"), "3"},
		{"3 + 3", []byte("3 3"), "6"},
		{"1 + 3", []byte("1 3"), "4"},
	}
	for _, tt := range tests {
		t.Run(tt.description, func(t *testing.T) {
			output := runTC(tt.tc, entry)
			if tt.ac != output {
				t.Errorf("got %s but expected %s", output, tt.ac)
			}
		})
	}
}
