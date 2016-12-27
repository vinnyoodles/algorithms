## Table of Contents
- [Pascal's Triangle](#pascal's-triangle)
- [Number of Paths in a Matrix](#number-of-paths-in-a-matrix)
- [Depth of an Array](#depth-of-an-array)
- [0-1 Knapsack](#0-1-knapsack)
- [Staircase](#staircase)

## Pascal's Triangle
#### Problem
Given an integer n, return an array with n levels of Pascal's triangle. Pascal's triangle is defined as the rth column of the nth row is n! / ( r! x (n - r)!)

#### Input/Output
```
Input: 4
Output: [
    [1],
   [1, 1],
  [1, 2, 1],
 [1, 3, 3, 1]
]
```

#### Explanation
The key to solving this problem is notice the pattern in the triangle besides the given formula. The brute force solution would be to solve for every value of each column using the factorial formula, but that would be inefficient when getting to a larger value of n.

The pattern becomes more noticeable when there are more levels in the triangle. The things to notice for are:
- The number of columns for a specific level is equal to that level number.
- Each row begins and ends with 1, except the first row which consists of just 1.
- The value at row *r* column *c* is equal to `triangle[r - 1][c] + triangle[r - 1][c - 1]`.
  - Ex. The value at row 3 column 1 would be equal to `triangle[2][1] + triangle[2][0] => 2 + 1`.

Therefore, to build Pascal's triangle up to n levels would be to start with the first level and build from there. The time complexity is O(n) and the space complexity is O(n) where n is the number of values in the triangle.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/recursion/pascalsTriangle.js)

## Number of Paths in a Matrix

#### Problem
Given a maze represented by a two dimensional array of size n *x* m, return the total number of paths to traverse from the origin (0, 0) to the bottom right corner (x - 1, y - 1). The maze has walls which are represented with the value 1.

#### Input/Output
```
Input: [
  [0, 0, 0, 0],
  [0, 1, 1, 0],
  [0, 1, 1, 0],
  [0, 0, 0, 0]
]
Output: 2
```

#### Explanation
The solution would traverse the matrix similar to a depth first search. First, we'll go as far right as we can until we either meet a wall or the boundary, then head down. The thing to look out for in this problem are the base cases. Depending on how the recursive traversal is setup, we have to make sure we don't get an `Array Out of Bounds` error.

The base cases are:
- Out of the grid's boundaries.
- In one of the grid's walls.
- In the end goal spot.

The complexities for this implementation is O(n*m) and O(1) for time and space respectively where n is the height and m is the width.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/recursion/numberOfPathsInMatrix.js)

## Depth of an Array

#### Problem
Given an arbitrary array, return a table with each value in the array pointing to its path using its indexes. An arbitrary array is defined as an array with values as either integers or a nested arbitrary array.

#### Input/Output
```
Input: [1, 2, [3, [4]]]
Output: {
  1: [0],
  2: [1],
  3: [2, 0],
  4: [2, 1, 0]
}
```

#### Explanation
Before implementing this, make sure you have a clear understanding of the *index path* to each value. In the given example, that path for the value `4` is `[2, 1, 0]`. Since the path has 3 values, then the value is 3 arrays deep in the original array where it's in the 2nd index of the first array, 1st index of the second array, and 0th index of the third array where each array is nested in the array before it.

The best data structure to use to represent the path is a stack. Start by looping through the first array and pushing the current index into the stack. If the value is a number, then just add it to the table and pop the index off the stack. If the value is another array, loop through that array with the current stack. This way, the index of the previous arrays would be kept in the stack in the order they appear. Also, make sure to pop off the index after iterating the nested array.

The complexities for this implementation is O(n) for both time and space where n is the number of values in the array.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/recursion/depthFinder.js)

## 0-1 Knapsack

#### Problem
Given a set of items, each with weight and benefit, determine the items to include in the knapsack so that the total weight is less than or equal to a given weight limit and the total benefit is maximized.

#### Input/Output
```
Input: [{
  weight: 2,
  benefit: 3
}, {
  weight: 2,
  benefit: 7
}, {
  weight: 4,
  benefit: 2
}, {
  weight: 5,
  benefit: 9
}]
Output: [0, 1, 3]
```

#### Explanation
The naive solution would be to find every solution. Since there are only two choices for every item, either add it to the knapsack or drop it, so the runtime would be exponential. It would look like a recursive function whose callstack would grow like a binary tree.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/recursion/knapsack.js)

## Staircase

#### Problem
How many combinations would ascending an *n* staircase where *n* is the number of steps and only steps of 1, 2 or 3 can be performed.

#### Input/Output
```
Input: 3
Output: 4
```

#### Explanation
The combinations for a staircase with 3 steps are:
```
1 + 1 + 1
1 + 2
2 + 1
3
```

The first thought for this solution should be recursion.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/recursion/knapsack.js)
