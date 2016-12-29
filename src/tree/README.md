## Table of Contents
- [Tree Traversal](#tree-traversal)
- [Sort Tree by Columns](#sort-tree-by-columns)
- [Path Sum](#path-sum)

## Tree Traversal
#### Problem
Given a binary tree, return the path for the three types of traversal: pre order, in order, and post order.

#### Input/Output
```
Input:
    4
   / \
  2   5
 / \   \
1   3   6

Output: [4, 2, 1, 3, 5, 6] // Pre order
        [1, 2, 3, 4, 5, 6] // In order
        [1, 3, 2, 6, 5, 4] // Post order
```

#### Explanation
For all three traversal, create an array and depending on the order, push the TreeNode value into the array. The pre order traversal goes current, left, then right node. The in order traversal goes left, current, then right node. The post order traversal goes left, right, then current node.

An easy way to remember this is to push the current node depending on the name of the traversal. So for pre order traversal, the current node goes before the left and right. Notice how the left node is always before the right node for all the traversals. Something else to notice is that if the tree is a binary search tree, then an in order traversal's path would be sorted.

All traversals run in O(n) time and space where n is the number of nodes in the tree.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/tree/TreeNode.js)

## Sort Tree by Columns
#### Problem
Given a binary tree, return an array with the values in the array in column sorted order.

#### Input/Output
```
Input:
    4
   / \
  2   5
 / \   \
1   3   6
Output: [1, 2, 4, 3, 5, 6]
```

#### Explanation
A column sort can be defined with the follow criteria:
- The root node is in row 0.
- Any node that is a child of another node will be in the row immediately following that of its parent.
- Any node that is a left child will be in the column immediately preceding that of its parent.
- Any node that is a right child will be in the column immediately following that of its parent.
- Any node that is a left child with a parent that is a right child will be in the same column as its grandparent.
- Any node that is a right child with a parent that is a left child will be in the same column as its grandparent.
- If two nodes share the same row and column, the node whose parent is a left child comes first.

Using the example tree, there are five columns: `[1], [2], [4, 3], [5], [6]`. The output array would then be the concatenation of all the columns in a top down order.

The trick for this problem is to use a breadth first search and a table to store each node under its column number. The column number is determined from its parent's column. A left child's column is `parent - 1` and a right child's column is `parent + 1`. Starting with the root node of column 0, traverse through the tree by each level.

The table for the above tree would then be
```
{
   0: [4, 3],
  -1: [2],
   1: [5],
  -2: [1],
   2: [6]
}
```

The only issue now is that the tables do not store the columns in any order so we have to know the smallest column index and the largest and iterate the table with the indexes in between inclusively.

The runtime and space complexity would be O(n) where n is the number of nodes in the tree. It is linear for the time complexity because it has to visit each node once when filling the table and a second iteration for the table itself. The space complexity is linear because we have to store the columns in a table as well as the returning array.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/tree/columnSort.js)

## Path Sum

#### Problem
Given a root node to a tree and a target value, *k*, return true if the tree contains a path between the root and any leaf such that the sum of all the values of the nodes on the path equal the target value.

#### Input/Output
```
Input:
    4
   / \
  2   5
 / \   \
1   3   6, 9
Output: true
```

#### Explanation
The given example has a path that sums up to 9, `[4, 2, 3]`. The solution can be solved using either breadth first search or depth first search.

This solution will use depth first search as it will make a recursive solution simpler. The idea is to start with the *k* value for the root node and traverse through the tree while looking for *k - n* where *n* is the current node's value.

So in the example, it would start at the root node with *k = 9*. When it traverses to the left subtree, it'll look for a path with *k = 5* since `k - rootNode = 9 - 4`. Once it reaches the first leaf node, 1, it will check if that leaf node's value is __**equal**__ to k, so *1 != 3*. The next leaf node, 3, is a valid path so end the traversal and return true.

The time and space complexity is O(n) and O(1) respectively where n is the number of nodes in the tree.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/tree/pathSum.js)
