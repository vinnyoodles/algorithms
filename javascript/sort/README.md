## Table of Contents
- [Merge Sort](#merge-sort)

## Merge Sort
#### Problem
Given an unsorted array, return the sorted array using a merge sort.

#### Input/Output
```
Input: [1, 5, 2, 4, 3, 6]
Output: [1, 2, 3, 4, 5, 6]
```

#### Explanation
The merge sort uses a divide and conquer method. It first divides the given array until subarrays of length 1. It then merges each subarray with each other. The sort portion occurs during the merge.

When dividing the array, split the array in half similar to a binary search. The trick for the merge is to not iterate through both subarrays but rather just compare the first two values. This is because the subarray will *always* be sorted. The subarray of 1 value will be sorted since it is by itself. When merging two subarrays, the outcome will be a sorted array twice the size of the initial subarray.

The merge sort can be visualized as.
```
Divide:
[1, 5, 2, 4, 3, 6]
[1, 5, 2], [4, 3, 6]
[1, 5], [2], [4, 3], [6]
[1], [5], [2], [4], [3], [6]

Merge:
[1], [5], [2], [4], [3], [6]
[1, 5], [2, 4], [3, 6]
[1, 2, 4, 5], [3, 6]
[1, 2, 3, 4, 5, 6]
```

The divide and merge portions can be done separately or one after the other. As in they can all be divided first and then merged or the first half can be divided which will then be merged before dividing the second half.

The time complexity is O(nlogn) and the space complexity is O(n) where n is the length of the array.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/sort/mergesort.js)
