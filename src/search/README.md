## Table of Contents
- [Binary Search](#binary-search)

## Binary Search
#### Problem
Given an array and a value, return the index of the value in the array or -1 if it does not exist.

#### Input/Output
```
Input: [1, 2, 3, 4, 5, 6, 7, 8, 9], 8
Output: 7
```
#### Explanation
Binary search relies on the given array to be sorted. The binary search works by dividing the array in half for every check where the check occurs in the midpoint of the current array.

For example, when searching for *8* in the given array, we first look at the midpoint value *5*. In this case, our value is larger so we will next look at the right half of the array. This is why a sorted array is necessary. The divide and check keeps occurring until the value is found. When the current becomes empty, then the value does not exist and return *-1*.

The time and space complexities for this is O(logn) and O(1) respectively. If the array isn't sorted then the runtime complexity would then be O(nlogn).

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/search/binarySearch.js)
