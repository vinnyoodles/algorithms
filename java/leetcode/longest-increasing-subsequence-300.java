/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 */
public int longestSubsequence(int[] arr) {
  if (arr.length == 0) return 0;
  int[] dp = new int[arr.length];

  // The subsequence at least contains itself.
  for (int i = 0; i < arr.length; i ++) 
    dp[i] = 1;

  int j = 0;
  int k = 1;
  int max = 1;

  // For every arr[k], find all arr[j] < arr[k].
  while (k < arr.length) {
    if (j == k) {
      max = Math.max(max, dp[k]);
      k ++;
      j = 0;
      continue;
    } 
    if (arr[j] < arr[k]) {
      dp[k] = Math.max(dp[k], dp[j] + 1);
    }
    j ++;
  }

  return max;
}