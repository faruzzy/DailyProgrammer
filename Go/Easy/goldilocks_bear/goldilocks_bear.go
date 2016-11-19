package main

import (
	"bufio"
	"log"
	"os"
)

func main() {
	f, err := os.Open("input.in")
	if err != nil {
		log.Fatal(err)
	}

	scanner := bufio.NewScanner(f)
}
