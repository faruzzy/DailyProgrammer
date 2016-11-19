// https://www.reddit.com/r/dailyprogrammer/comments/5aemnn/20161031_challenge_290_easy_kaprekar_numbers/
// TODO: take care of bug: k(2, 100) won't print for some obscure reasons .. weird
const fs = require('fs');

const [...lines] = fs.readFileSync('kaprekar_number.txt', 'utf8')
	.trim()
	.split('\n');

lines.forEach(line => {
	const [a, b] = line.split(' ');
	console.log(kaprekarNumber(a, b));
});

function kaprekarNumber(start=2, end=50) {
	const output = [];
	for (let j = start; j <= end; j++) {
		let curr = Math.pow(j, 2);
		curr = String(curr);
		if (curr.length > 1) {
			for (let k = 1; k < curr.length; k++) {
				const left = Number(curr.substr(0, k));
				const right = Number(curr.slice(k));
				if (left < j && right < j) 
					if (left + right === j) 
						output.push(j);	
			}
		}
	}	

	return output.join(' ');
}

// I had fun with this functional version :)
function k(start=2, end=50) {
	function range(s, e) {
		const arr = [];
		for (let i = s; i <= e; i++)
			arr.push(i);
		return arr;
	}

	const output = [];
	range(start, end).forEach((curr, idx) => {
		const val = String(Math.pow(curr, 2));
		if (val.length > 1) {
			val.split('').reduce((a, b, idx) => {
				if (idx === 0) return;	
				const left = Number(val.substr(0, idx));
				const right = Number(val.slice(idx));
				
				if (left < curr && right < curr)
					if (left + right === curr)
						output.push(curr);
			}, '');
		}
	});

	return output.join(' ');
}
