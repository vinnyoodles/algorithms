## Table of Contents
- [Greatest Subarray](#greatest-subarry)
- [Minimum Additions](#minimum-additions)

## Greatest Subarray
#### Problem
 Given an array, find the longest subarray whose sum is less than or equal to k. A subarray is defined to be a contiguous range of values that is within the bounds of the given array.

#### Input/Output
```
Input: [1, 3, 5, 7, 9, 11, 13, 15], 15
Output: 3
```

#### Explanation
The greatest subarray in the example array that sums up to k = 15 is `[1, 3, 5]` which has a length of 3. The example seems simple because the array is sorted so the solution may seem to be sum the array from left to right and once the sum is greater than k, then return the length of that array. This would only work for sorted arrays in increasing order.

The brute force solution would be to find all subarrays of the original which would be O(n<sup>2</sup>) time.
The optimal solution would run in O(n) time using the two pointers or sliding window algorithm.

Using the example above, start iterating from the left with two pointers where both start off at the first value.
```
[1, 3, 5, 7, 9, 11, 13, 15]
 ^
```
The idea is to keep moving the right pointer while keeping track of the sum of the current subarray.
```
[1, 3, 5, 7, 9, 11, 13, 15]
 ^     ^ // The current sum is now 9 with a length of 3.
```
When the current sum is greater than k, then we must decrease the size of the window or move the left pointer over.
```
[1, 3, 5, 7, 9, 11, 13, 15]
    ^     ^ // The current sum is now 15 with a length of 3.
```
The window will keep moving until the right pointer reaches the end. At that point, we know what the longest subarray is because we have kept track of it while iterating.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/array/greatestSubarray.js)

## Minimum Additions
#### Problem
Find the minimum number of operations to equalize all values in a unique array. The only valid operation is to incrementing a value by 1.

#### Input/Output
```
Input: [1, 2, 3, 4]
Output: 6
```

#### Explanation

The shortest number of operations would be to increase each value to equal the greatest value in the array, which is 4 in this case. The first index needs 3 operations, 2 operations for the second, and 1 for the third, so a total of 6 operations.

A simple solution would be to iterate through once to find the maximum value. Then, iterate a second time keeping track of the number of operations needed to get all values to equal the maximum. This would be O(n) time and O(1) space.

A small optimization can be made when thinking about what it means to equalize the array. The solution wants us to equalize the array by only incrementing, so set them all equal to the greatest value. But it would take the same number of decrementing operations to set them all equal to the lowest value. Knowing this we can perform the solution in one iteration by finding the minimum value and the total sum of the array. Then, the total number of operations would be equivalent to set setting all values equal to the minimum value or the difference between the current sum and the theoretical sum.
```
currentSum - theoreticalSum -> currentSum - (minimumValue * arrayLength)
```

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/array/minAdditions.js)
