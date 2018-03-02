# This problem was asked by Airbnb.
# Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
# For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

def maxNonAdjacentSum(arr):
    length = len(arr)
    if length == 0:
        return 0
    incl = arr[0]
    excl = 0

    for i in range(1, length):
        tmp = max(incl, excl)
        incl = arr[i] + excl
        excl = tmp

    return max(incl, excl)

assert(maxNonAdjacentSum([2, 4, 6, 8]) == 12)
assert(maxNonAdjacentSum([5, 1, 1, 5]) == 10)
assert(maxNonAdjacentSum([5, 5, 10, 100, 10, 5]) == 110)