## Notes, Tips + Tricks, and General Study Guide for Interviews

### Table of Contents
- [Definitions](#definitions)
- [Tips + Tricks](#tips--tricks)

### Definitions

**Set**
> A list of elements in any order. In general, sets are distinguished by the elements in them and not the specific ordering so sets with the same elements but a different ordering are considered duplicates. An empty set is considered to be a `null set` containing only the `null` element.

Ex. [ 1, 2, 3, 4, 5 ]

**Subset**
> Given a set `a` of elements, a subset would be another set `b` containing only elements from `a`. 
All sets contain the null element, therefore the null set is always a subset of any set. 
Because set `b` can only contain elements from `a`, the size of `b` is at most the size of `a`. 
For a set with `N` elements, there are exactly `2^N` subsets because for every element there are two choices: include the element or exclude the element. 
This can be visualized as a binary tree when making the recursive call.

Ex. `[ 1, 2, 3, 4, 5 ] => [ 2, 4 ]`

**Permutations**
> Given a set `a` of elements, a permutation of `a` would be a unique ordering of the elements in `a`. 
Because the ordering matters for this, the length of a **permutation is always equal to the length of the original set**.
For a set with `N` elements, there are exactly `N!` permutations. This is because when choosing the first value, there are N elements to choose from, the second value has N - 1, the third has N - 2, and so on.

Ex. `[ 1, 2, 3, 4, 5 ] => [ 1, 3, 5, 2, 4 ]`

**Combinations**
> Given a set `a` of elements, a combination of length `k` would be a valid subset of `a` of length `k`.
For a set with `N` elements, there are exactly **N! / (N - k)! (k)!** combinations commonly known as N choose k.

Ex. `[ 1, 2, 3, 4, 5 ] => [ 2, 3, 4 ]` where k = 3

**Subarray**
> The strict definition of a subarray is a subset of elements of the given array. 
Many interview problems regarding subarray also include contiguous or continuous in the problem statement which makes a big difference.
Usually, if this comes up in an interview, **always clarify whether the subarray is continuous or not**.

Ex. `[ 1, 2, 3, 4, 5 ] => [ 4, 2, 3 ]` (non continuous subarray)

Ex. `[ 1, 2, 3, 4, 5 ] => [ 2, 3, 4 ]` (continuous subarray)

**Substring**
> A substring is a **continuous subset** of characters of the given string

Ex. `foobar => foo`

Ex. `foobar => bar`

Ex. `foobar => ooba`

**Subsequence**
> A subsequence of a set of elements is a **non continuous subset** where the original ordering must be maintained.

Ex. `foobar => foo`

Ex. `foobar => foba`

Ex. `[ 1, 2, 3, 4, 5 ] => [ 2, 3, 4 ]`

Ex. `[ 1, 2, 3, 4, 5 ] => [ 2, 4 ]`


### Tips + Tricks

#### HashMap/HashTable

- For problems regarding counting the frequency of elements, a hashmap/hashtable is useful because it allows a 1 to 1 mapping. 
The mapping can be either frequency to element or element to frequency.

#### Tree

- For problems regarding depth of a tree, BFS is usually the go to algorithm for traversal.
This is because will iterate the depths in increasing order. Here's an example/skeleton for implementing BFS
on a binary tree.
```java
while (!queue.isEmpty()) {
  int numberOfNodesInDepth = queue.size();
  for (int i = 0; i < numberOfNodesInDepth; i ++) {
    // Poll the next node.
    // Add all the relevant child nodes (these children are guaranteed to be on the next depth).
  }
  // When the above loop ends, we are guaranteed that we have reached the end of a depth level.
}
```

#### Array
- When the brute force solution requires nested for loops such that the runtime becomes a polynomial, try to apply the two, three or n pointers to the problem to reduce the complexity.
For example, the common 2 sum problem has a brute force of N^2 where you find all possible pairs, however if the array is already sorted and pairs are found using two pointers then the runtime can be reduced to O(N)
