# Given an array of numbers, return whether any two sums to K.
# For example, given [10, 15, 3, 7] and K of 17, return true since 10 + 7 is 17.

def two_sum(arr, target):
    seen = set()
    for num in arr:
        complement = target - num
        if complement in seen:
            return True 
        seen.add(num)
    return False

print(two_sum([10, 15, 3, 7], 17))
print(two_sum([10, 15, 3, 7], 10))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 0))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 10))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 15))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 25))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 1))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 11))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 16))
print(two_sum([1, 2, -5, 5, -10, 20, -25], 26))
