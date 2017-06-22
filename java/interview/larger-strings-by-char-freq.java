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
public int[] numOfLargerStrings(String[] a, String[] b) { 
  String[] aStrs = a.split("\\s");
  String[] bStrs = b.split("\\s");
  int[] values = new int[aStrs.length];
  int[] result = new int[bStrs.length];
  int i = 0;

  // Count the frequency value for each string.
  while (i < aStrs.length || i < bStrs.length) {
    if (i < aStrs.length) values[i] = lexicographicalValue(aStrs[i]);
    if (i < bStrs.length) result[i] = lexicographicalValue(bStrs[i]);
    i ++;
  }

  // Count the number of strings in a that are less than the string in b.
  for (int j = 0; j < bStrs.length; j ++) {
    int count = 0;
    for (int k = 0; k < aStrs.length; k ++) {
      if (aStrs[k] < bStrs[j]) count++;
    }
    result[i] = count;
  }

  return result;
}

/**
 * Helper function to count the lexicographical value of the string.
 */
public int lexicographicalValue(String str) {
  char[] arr = str.toCharArray();
  Arrays.sort(arr);
  int count = 0;
  for (char c : arr) {
    if (c == arr[0]) count ++;
    else break;
  }

  return count;
}
