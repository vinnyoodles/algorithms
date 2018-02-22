# This problem was asked by Uber.
# Given an array of integers, return a new array such that each element at index i of the new array
# is the product of all the numbers in the original array except the one at i.
# Solve it without using division and in O(n) time.
# For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
# If our input was [3, 2, 1], the expected output would be [2, 3, 6].

def product_array(arr):
    length = len(arr)
    left = [1] * length
    right = [1] * length
    result = [1] * length
    left_index = 0
    while left_index < length:
        right_index = length - left_index - 1

        if left_index - 1 >= 0:
            left[left_index] = arr[left_index] * left[left_index - 1]
        else:
            left[left_index] = arr[left_index]

        if right_index + 1 < length:
            right[right_index] = arr[right_index] * right[right_index + 1]
        else:
            right[right_index] = arr[right_index]

        left_index += 1


    for i in range(length):
        left_val = 1
        right_val = 1

        if i > 0:
            left_val = left[i - 1]

        if i < length - 1:
            right_val = right[i + 1]
        result[i] = left_val * right_val

    return result


print(product_array([1, 2, 3, 4, 5]))
print(product_array([3, 2, 1]))

