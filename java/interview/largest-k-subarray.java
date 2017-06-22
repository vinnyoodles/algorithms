/**
 * @Company Google
 *
 * Given an array of length n and an integer k where 0 < k <= n, find the largest subarray of length k by the following definition.
 * Subarray A is larger than subarray B if the value at index i is greater. Similar to the lexicographical ordering of strings.
 * The first occurence of a value that differs between A and B will determine which ever is bigger.
 * 
 * Ex. [ 1, 2, 2, 2, 4 ] is larger than [ 1, 2, 2, 2, 3 ]
 *     [ 1, 4 ] is larger than [ 1, 2 ]
 *
 * Problem Ex.
 *   Input: [ 1, 4, 1, 4, 5 ], k = 3
 *   Output: [ 4, 1, 4 ]
 *
 *   There are 3 subarrays of length 3 in the given array, [ 1, 4, 1 ], [ 4, 1, 4 ], [ 1, 4, 5 ].
 *   The ordering of the three subarrays from greatest to least are as follows:
 *   [ 4, 1, 4 ]
 *   [ 1, 4, 5 ]
 *   [ 1, 4, 1 ]
 * 
 *   [ 4, 1, 4 ] is the largest because its first index is already greater than the other two subarrays.
 *   Since we want the greatest subarray, the answer will be the first one.
 *   The order of the next two are determined at index 2 because 5 > 1.
 *
 * Note: there are n - k + 1 subarrays in an array of length n of size k.
 */
public static int[] largestSubarray(int[] arr, int k) {
  int numOfSub = arr.length - k + 1;
  int[][] subarrays = new int[numOfSub][k];
  int maxIndex = 0;

  for (int i = 0; i < numOfSub; i ++) {
    boolean updated = false;
    for (int j = 0; j < k; j ++) {
      subarrays[i][j] = arr[i + j];

      // If the current subarray is the max subarray, then just populate.
      // Also, if the max subarray has already been updated then, just populate.
      // Also, continue if the two values are equal.
      if (i == maxIndex || updated || subarrays[i][j] == subarrays[maxIndex][j]) continue;

      // New max sub array
      if (subarrays[i][j] > subarrays[maxIndex][j]) maxIndex = i;

      // Set update to true regardless of which is greater.
      updated = true;
    }
  }

  return subarrays[maxIndex];
}