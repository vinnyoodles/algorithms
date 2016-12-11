## Table of Contents
- [Merge two lists](#merge-two-lists)
- [Reverse a Linked List](#reverse-a-linked-list)
- [Sum of Two Linked Lists](#sum-of-two-linked-lists)

## Merge two linked lists
#### Problem
Given two sorted linked lists, merge the lists to a single sorted linked list.

#### Input/Output
```
Input: 1 -> 3 -> 5
       2 -> 4 -> 6
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
```

#### Explanation
Create a dummy node and iterate through the lists and only add the current smaller node to the end of the dummy node list. Keep traversing the lists, node by node.

*Note*, only traverse the list that is being added. So in the example above, it would first add the node from list A (1). So it should only traverse list A and not list B as well or it would skip the node with the value of 2.

The complexity of this solution is O(n) time and O(1) space. All solutions would have to iterate through both lists at least once so the optimal solution is linear time. For space, it is only creating a single dummy node in the start so it is constant space.

## Reverse a Linked List
#### Problem
Given a linked list, return a linked list in reverse order.

#### Input/Output
```
Input: 1 -> 2 -> 3
Output: 3 -> 2 -> 1
```

#### Explanation
The problem is pretty simple, except for one small issue, because it is a linked list we do not know how long the given list is. This makes it tricky because we do not know the head node of the reversed list until we get to it.

The idea for this solution is to work backwards, which is a pretty common trick for a lot of linked list and array problems. Instead of initializing the head and each subsequent next node, we will start by initializing the tail which in this case *is the head node* of the original list.

__But how can we work backwards if the list is a singly linked list?__

The trick is to have a fake head node which we will be appending to. The fake head node can be any value (let's use -1) and will always be constant.

For example, while running through the given list, we will call that current node, *node A*. We'll create a temporary node with same value as *node A* so that we don't mutate the given list. Then, intersect the temporary node with the fake head and then point the fake head to the temporary node.

```
1 -> 2 -> 3

-1 -> null
-1 -> 1 -> null
-1 -> 2 -> 1 -> null
-1 -> 3 -> 2 -> 1 -> null
```

This implementation will run in O(n) time where n is the length of the list and O(n) space since we are creating a new list.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/linkedlist/reverseList.js)

## Sum of Two Linked Lists

#### Problem
Given two linked lists, where each list represents a number in reverse order, return the linked list that represents the sum of the given two lists.

#### Input/Output
```
Input: 1 -> 2 -> 3
       4 -> 5 -> 6
Output: 5 -> 7 -> 9
```
#### Explanation

First, what it means by reverse order is that the head node represents the 1s digits and the next node will be the 10s digit and so forth.

The solution would be to run through both lists in parallel and perform the sum for those two current nodes. This way, we will have to initialize a third list as well as a carry variable to keep track of any 1s that have to be carried over. One thing to think about before implementing is that the greatest sum possible would be 18 (9 + 9) therefore the carry variable will always either be 0 or 1.

Another thing to think about is if one list is longer than the other. To solve for this, just iterate through both in parallel and if one of the lists has reached its end, then just substitute 0 in for it and __do not__ run through that list anymore since it's at its end.

The last thing to think about is once both lists have reached its end, we'll have to check if there is anything left in the carry value. If so, just append it to the third list.

This implementation would run in O(n) time and O(n) space where n is the length of the longest list. There is no way to optimize the runtime because we will *have* to run through each list once. But we can optimize the space complexity. Rather than create a third list, we can do the summation in place using either of the two given lists. If whichever list we've chosen is the shorter one, then just create a new node and keep running until we've reached the end.

The optimal solution would be O(n) time and O(1) space.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/linkedlist/sumLists.js)
