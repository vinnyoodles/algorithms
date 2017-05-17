## Table of Contents
- [Longest Subsequence](#longest-subsequence)
- [Balanced Parentheses](#balanced-parentheses)
- [Knuth Morris Pratt](#knuth-morris-pratt)
- [Is Palindrome](#is-palindrome)
- [Longest Palindrome](#longest-palindrome)

## Longest Subsequence
#### Problem
Given two strings, find the length of the longest subsequence that is found in both. A subsequence is defined as a subset of a string that does not have to be continuous.

#### Input/Output
```
Input: 'abcd'
       'xzyabcmno'
Output: 3
```

#### Explanation

*Updated 5/17/17*

This uses dynamic programing by breaking down one of the strings.

For example, given string A of length n (a1, a2, a3, ..., an) and B of length m (b1, b2, b3, ... bm), we can find all subsequence of A in { b1 }, then { b1, b2 }, up until { b1, b2, ..., bm}. Because we are always adding more characters as the subproblem grows, the longest subsequence is at least the length of the prior subsequence. 

When adding character by character, we check the current longest subsequence and update it for that subproblem. Continue this until the last subproblem is the entire string. 

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/string/longestSubsequence.js)

## Balanced Parentheses
#### Problem
Check if a sequence of different types of brackets (or parentheses) is correctly balanced, return true if it is and false otherwise.

#### Input/Output
```
Input: '{}[]()'
Output: true
```

#### Explanation
The key to this problem is to use a stack to keep track of the current opened parentheses.

The determining factor on whether an expression is valid or not is solely based on the closing brackets. So the trick is to iterate through the expression and add all the opened brackets to the stack. While traversing, if a closing bracket is met and it *does not* match the top of the stack, then the expression is invalid. If it does match, then pop the matching opening bracket off the stack and continue on. The expression is only valid *if* the traversal is complete and the stack is empty.

The complexities for this problem is linear and constant for time and space complexity. It runs in linear time because the solution needs to visit each character in the expression. The space is constant because the stack will only have at most half of the expression, if it is valid. The stack may contain the entire expression, *if and only if* the expression consists of only open brackets.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/string/balancedParentheses.js)

## Knuth Morris Pratt
#### Problem
Find the index of the target string or the needle in the search string or the haystack using the Knuth Morris Pratt string searching algorithm.


#### Input/Output
```javascript
Input: 'abc abcdab abcdabcdabde' // Haystack
       'abcdabd' // Needle
Output: 2
```

#### Explanation
The algorithm utilizes a fail table to map back to the last occurence of the partially matched string. Using the fail table, we can optimize the runtime when searching for a large needle in a large haystack because we would not have to reiterate through the partially matched string.

In the example given, there is a partial match in the haystack at index 12. The last character doesn't match so we have to keep looking, but the partial string `ab` in the needle also occurs near the end of it. We can move the search string straight to index 16 because of this.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/string/kmp.js)

## Is Palindrome
#### Problem
Return true if the given string is a palindrome.

#### Input/Output
```javascript
Input: 'racecar'
Output: true
```

#### Explanation
The solution should be trivial. There are multiple linear solutions for this problem. The most common one is to compare the first char with the last, the second with the second to last, third with third to last, etc. Another solution relying on the language standard library is to flip the string and compare the original with the reverse.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/string/isPalindrome.js)

## Longest Palindrome
[Source](https://leetcode.com/problems/longest-palindromic-substring/)
#### Problem
Given a string, return the longest valid palindrome in the string.

#### Input/Output
```javascript
Input: 'foodracecarapples'
Output: 'racecar'
```

#### Explanation
The solution requires some thought. There are a few ways to do this in quadratic time and no memory, for example the implementation I included. It involves checking if a substring at a certain center location is a palindrome. It performs this check with the center location as every character in the string. There are *n* characters and the check is at most O(n) time, therefore the runtime is O(n^2).

There is an optimal solution running in O(n) time called *Manacher's algorithm*. I will try to implement that solution in the future.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/string/longestPalindrome.js)

