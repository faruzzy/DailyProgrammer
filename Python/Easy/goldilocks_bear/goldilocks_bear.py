#!/usr/bin/python
# https://www.reddit.com/r/dailyprogrammer/comments/5bn0b7/20161107_challenge_291_easy_goldilocks_bear/
def main():
    lines = []
    output = []
    #inputFile = 'input.in'
    inputFile = 'challenge_input.in'
    with open(inputFile) as f:
        lines = f.readlines()

    weight, max = [int(v) for v in lines[0].split(' ')]
    seats = [seat.strip() for seat in lines[1:]]

    for i in range(0, len(seats)):
        w, m = [int(s) for s in seats[i].split(' ')]
        if w > weight and m < max:
            output.append(i + 1)
    list = ' '.join([str(i) for i in output])
    print(list)

if __name__ == '__main__':
    main()