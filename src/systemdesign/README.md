## Table of Contents
- [LRU Cache](#least-recently-used-cache)

## Least Recently Used Cache
#### Problem
Design and implement a data structure for Least Recently Used cache. It should support the following operations: get and set.

`get(key)` - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
`set(key, value)` - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

#### Input/Output
```
Input: 5
Output: Cache of max size 5
```

#### Explanation
There are many ways to design a least recently used cache. The optimal complexity for this cache is O(1) runtime and O(n) space. 

My implementation is currently O(n) for both time and space. It uses a hash table for constant lookup as well as a linked list for quick eviction. The head of the linked list represents the most recently used and the head of the list represents the least recently used. When evicting a node, it would just remove the tail. When updating a node (marking as most
recent), it would move the node to the head of the list. 

The reason why I wasn't able to achieve O(1) runtime is because when it is updating the linked list, it has to iterate through the list to find the previous node in order to move the node to the head of the list. A solution for constant update and eviction would be to use a doubly linked list so that it would not have to iterate through the list in order to find the previous node. 
