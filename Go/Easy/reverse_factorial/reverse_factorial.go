//https://www.reddit.com/r/dailyprogrammer/comments/55nior/20161003_challenge_286_easy_reverse_factorial/
package main

import "fmt"

func main() {
	reverseFactorial(120)
	reverseFactorial(3628800)
	reverseFactorial(479001600)
	reverseFactorial(6)
	reverseFactorial(18)
	reverseFactorial(16)
}

func reverseFactorial(val int) {
	current := val
	i := 2

	for current%i == 0 {
		result := current / i

		if result != 1 {
			i++
			current = result
		} else {
			fmt.Printf("%d! = %d\n", val, current)
			return
		}
	}

	fmt.Printf("%d! =  %s\n", val, "None")

}
