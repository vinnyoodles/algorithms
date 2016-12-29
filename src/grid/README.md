## Table of Contents
- [Largest Neighbor](#largest-neighbor)
- [Grid Traversal by the Largest Neighbor](#grid-traversal-by-the-largest-neighbor)

## Largest Neighbor
#### Problem
Find the neighbor of the current node in a given grid with the greatest value. If no neighbor with a value greater than 0 exists, then return an empty node.

#### Input/Output
```
Input: { x: 0, y: 0}, [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
Output: { x: 0, y: 1 }
```
#### Explanation
This problem is pretty simple, its mostly implemented for the [Grid Traversal by the Largest Neighbor](#grid-traversal-by-the-largest-neighbor) problem. Just look at the neighbors of the current node. There would be at most 4 neighbors and at least 2 neighbors.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/grid/largestNeighbor.js)

## Grid Traversal by the Largest Neighbor
#### Problem
Given a grid and a starting location, traverse the grid by following the largest neighbor. A node's neighbor is confined to only the cardinal directions (north, south, east and west). When traversing, prioritize neighbors with greatest value. The traversal ends when the node no longer has an neighbors with a value greater than 0. Return the path of the traversal.

#### Input/Output
```
Input: { x: 0, y: 0}, [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
Output: [1, 4, 7, 8, 9, 6, 5, 2, 3]
```

#### Explanation
The solution uses a depth first search with the [Largest Neighbor](#largest-neighbor) as the priority. Starting at the given location, find the largest neighbor and set the current location as visited then move to that neighbor. Continue this traversal until there are no more valid neighbors.

The space and time complexities for this is O(n*m) for both where *n* is the width and *m* is the height.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/grid/gridTraversal.js)
