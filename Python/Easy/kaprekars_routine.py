#!/usr/bin/python

def main():
    largest_digit(1234)
    largest_digit(3253)
    largest_digit(9800)
    largest_digit(3333)
    largest_digit(120)

    print('\n')

    desc_digits(1234)
    desc_digits(3253)
    desc_digits(9800)
    desc_digits(3333)
    desc_digits(120)

def largest_digit(val):
    curr = str(val)
    if len(curr) < 4:
        for i in range(len(curr), 4):
            curr = '0{0}'.format(val)

    m = ''
    for char in curr:
        if char > m:
            m = char
    print('{0}({1}) -> {2}'.format('largest_digit', val, m))

def desc_digits(val):
    curr = str(val)
    if len(curr) < 4:
        curr = '0{0}'.format(curr)
    curr = ''.join(sorted(curr, reverse=True))
    print('{0}({1}) -> {2}'.format('desc_digits', val, curr))

if __name__ == '__main__':
    main()
