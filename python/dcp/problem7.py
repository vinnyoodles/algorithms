# This problem was asked by Facebook.
# Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
# For example, the message '111' would give 3, since it could be decoded as 'aaa, 'ka', and 'ak'.

def encoding(input):
    length = len(input)
    arr = [0] * (length + 1)
    arr[0] = 1

    for i in range(1, length + 1):
        if input[i - 1] != '0':
            arr[i] = arr[i - 1]

        double_digit = input[i - 2:i]
        if i > 1 and double_digit > '09' and double_digit < '27':
            arr[i] += arr[i - 2]

    return arr[length]

assert(3 == encoding('111'))
assert(2 == encoding('12'))