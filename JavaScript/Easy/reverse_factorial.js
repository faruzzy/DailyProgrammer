// https://www.reddit.com/r/dailyprogrammer/comments/55nior/20161003_challenge_286_easy_reverse_factorial/
function reverseFactorial(v) {
	let current = v;
	let i = 2;

	while (current % i === 0) {
		let result = current / i;
		if (result !== 1) {
			i++;
			current = result;
		} else {
			return `${v} = ${current}`;
		}
	}

	return 'None'
}

console.log(reverseFactorial(120));
console.log(reverseFactorial(3628800));
console.log(reverseFactorial(479001600));
console.log(reverseFactorial(6));
console.log(reverseFactorial(18));
console.log(reverseFactorial(16));
