#!/usr/bin/python
'''
https://www.reddit.com/r/dailyprogrammer/comments/55nior/20161003_challenge_286_easy_reverse_factorial/

Nearly everyone is familiar with the factorial operator in math. 5! yields 120
because factorial means "multiply successive terms where each are one less than
the previous":
    5! -> 5 * 4 * 3 * 2 * 1 -> 120
    Simple enough.
    Now let's reverse it. Could you write a function that tells us that "120" is
    "5!"?
    Hint: The strategy is pretty straightforward, just divide the term by
    successively larger terms until you get to "1" as the resultant:
        120 -> 120/2 -> 60/3 -> 20/4 -> 5/5 -> 1 => 5!
'''
def main():
    print(reverseFactorial(120))
    print(reverseFactorial(3628800))
    print(reverseFactorial(479001600))
    print(reverseFactorial(6))
    print(reverseFactorial(18))
    print(reverseFactorial(16))

def reverseFactorial(val):
    curr = val
    i = 2

    while curr % i == 0:
        result = curr / i
        if result != 1:
            i += 1
            curr = result
        else:
            return '{0} = {1}'.format(val, curr)
    return 'None'

if __name__ == '__main__':
    main()
