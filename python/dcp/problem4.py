# This problem was asked by Stripe.
# Given an array of integers, find the first missing positive integer in linear time and constant space.
# In other words, find the lowest positive integer that does not exist in the array. 
# The array can contain duplicates and negative numbers as well.
# For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
# You can modify the input array in-place.
###########################################
# Explanation
# First, the answer must lie in the range 1 - len(arr).
# This is because we want the smallest increasing number so we have to think of
# the worst case (answer would be the largest in the array).
# Knowing that the answer must be in a specific range, we can use the arr as a lookup table.
# First, place all valid numbers where they belong.
# Then, find the first number that does not belong.
def findingFirstMissingPositive(arr):
    length = len(arr)
        if length == 0:
            return 1
        for index in range(length):
            value = arr[index]
            while value <= length and value > 0 and arr[value - 1] != value: 
                new_value = arr[value - 1]
                arr[value - 1] = value
                value = new_value
            
        for index in range(length):
            if arr[index] != (index + 1):
                return index + 1
            
        return length + 1