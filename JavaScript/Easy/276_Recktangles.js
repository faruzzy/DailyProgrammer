/**
 * https://www.reddit.com/r/dailyprogrammer/comments/4tetif/20160718_challenge_276_easy_recktangles/
 */

const text = 'REKT';
const width = 2;
const output = [];

let len = text.length;
for (let i = 0; i < width; i++) {
	for (let s = 0; s < len; s++)
		output.push(text[s]);
	
	if (i + 1 !== width) {
		let end = (i + 1 === width) ? 0 : 1
		for (let k = len - 2; k >= end; k--) {
			output.push(text[k]);
		}
	}
}

console.log('the result ', output.join(''));
