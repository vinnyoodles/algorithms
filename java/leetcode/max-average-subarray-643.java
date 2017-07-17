/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * The solution is trivial as there are n - k + 1 subarrays.
 */
public class Solution {
  public double findMaxAverage(int[] nums, int k) {
    if (nums.length == 0) return Integer.MIN_VALUE;
    double sum = 0;
    for (int i = 0; i < k && i < nums.length; i ++) {
      sum += nums[i];
    }
    double max = sum / k;
    int i = 0;
    int j = k;
    while (j < nums.length) {
      sum = sum - nums[i++] + nums[j++];
      max = Math.max(max, sum / k);
    }

    return max;
  }
}