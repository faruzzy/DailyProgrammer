// https://www.reddit.com/r/dailyprogrammer/comments/3kx6oh/20150914_challenge_232_easy_palindromes/
const fs = require('fs');

const fileName = 'input.in';
const [,...tokens] = fs.readFileSync(fileName, 'utf8');

if (isPalindrome(tokens.join('')))
	console.log('Palindrome');
else
	console.log('Not a Palindrome');

function isPalindrome(str) {
	str = str.replace(/[\W]/g, '').toLowerCase()
	for (let k = 0, len = str.length; k < len; k++)
		if (str[k] !== str[len -1 -k])
			return false;
	return true;
}