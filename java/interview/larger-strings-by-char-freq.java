/**
 * @Company Google
 *
 * Given two string arrays, A and B, return an array of length B where each value at index i corresponds to the number of strings
 * in A that are less than the string in B at index i. The string comparator is defined as follows:
 * 
 * String A is greater than String B if the first lexicographical order character in A is more frequent than the first lexicographical order in B.
 * The lexicographical is the ordering of the alphabet.
 *
 * Ex. 'aabbbccc' is greater than 'bcccc' since there are 2 a's vs 1 b
 *     'aaa' is less than 'cc' since there are 3 a's vs 2 c's
 *
 * Problem Ex.
 *   Input: [ 'abc', 'aab', 'aaa' ], [ 'aazz', 'abc', 'aaaaaaa' ]
 *   Output: [ 1, 0, 3 ]
 *
 *   'aazz' has a value of 2 which is greater than 'abc'
 *   'abc' has a value of 1 which is greater than nothing in array A
 *   'aaaaaaa' has a value of 7 which is greater than 'abc', 'aab', 'aaa'
 */
public int[] numOfLargerStrings(String[] a, String[] b) { }
