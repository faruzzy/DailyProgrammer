/**
 * https://www.reddit.com/r/dailyprogrammer/comments/79npf9/20171030_challenge_338_easy_what_day_was_it_again/
 *
 * What day of the week did hitler get elected on?
 * What day of the week did the Normans invade Britain on?
 * What day of the week did Jesus die on?
 * What day of the week did MacDonald get founded on?
 * Today we're gonna find out
 * For todays challenge you are allowed to use your languages built in Calender functions/classes.
 * But it's more interesting if you do the calculation yourself :)
 * Hint
 *
 * It's leap-year if the year is divisible by 4
 * Ignore leap-year if the year is divisible by 100
 * Ignore previous rule if the year is divisible by 400
 *
 * The input will be 3 integers as such:
 * YEAR MONTH DATE
 * Limits for the 3 integers:
 * 8000 > YEAR > 0
 * 13 > MONTH > 0
 * 32 > DATE > 0
 * Sorry to anyone starting at 0.
 * January is 1 and December is 12
 * Assume all dates to be correct (i.e. no 31th of february)
 *
 * Input will look like:
 * 2017 10 30
 *
 * Output Example:
 * Monday
 *
 */
const fs = require('fs');

const [...lines] = fs.readFileSync('./what_day_was_it_again.txt', 'utf8')
	.trim()
	.split('\n');

const arr = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
lines.forEach(line => {
	const [year, month, day] = line.split(' ');
	console.log(`${line}: ${arr[new Date(year, month, day).getDay()]}`);
});