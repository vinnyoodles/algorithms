## Table of Contents
- [Longest Subsequence](#longest-subsequence)

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
