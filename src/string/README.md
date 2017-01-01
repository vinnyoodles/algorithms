## Table of Contents
- [Longest Subsequence](#longest-subsequence)
- [Balanced Parentheses](#balanced-parentheses)
- [Knuth Morris Pratt](#knuth-morris-pratt)

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
The solution for this utilizes two pointers to keep track of the current subsequence that is being tracked. The two pointers would be tracking the shorter of the two strings, while a loop will be used to iterate through the longer string. For every match that occurs in the longer string and the current character that the right pointer is looking at, move the right pointer to the next character.

The issue comes when the character that the right pointer is at *is not found*. When this occurs, we'll move both the left pointer so skipping that character since it did not occur in the longer string.

Here's what that would look like with the example above.
```
abcd -> The shorter string
^
xzyabcmno -> Let's just skip the first few iteration until we hit the first match
   ^

abcd
^ ^
xzyabcmno // This is valid subsequence so track this length.
   ^ ^

abcd
^  ^
xzyabcmno
   ^    ^
There's no match for the last character and we're at the end of both strings, so that's the end.
```
In all scenarios, the space complexity is O(1). For runtime, the best case is O(n) where n is the length of the longer string where the shorter string is a full subsequence is the longer string. The worst case runtime is O(n<sup>2</sup>) where both strings are of equal length and only the last character of the first string occurs in the second string causing us to loop through the second string for each character in the first string.

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
