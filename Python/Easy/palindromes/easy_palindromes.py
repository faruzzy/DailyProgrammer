#https://www.reddit.com/r/dailyprogrammer/comments/3kx6oh/20150914_challenge_232_easy_palindromes/

#!/usr/bin/python
import re
def main():
    with open('input.in') as f:
        count = int(f.readline())
        content = ''
        for i in range(0, count):
            content += f.readline()
    content = re.sub(r'[\W\s\n]','', content)
    is_palindrome(content.lower())

def is_palindrome(s = ''):
    for i in range(0, len(s) / 2):
        if (s[i] != s[len(s) -1 -i]):
            print('Not a palindrome')
            return
    print('Palindrome')

if __name__ == '__main__':
    main()