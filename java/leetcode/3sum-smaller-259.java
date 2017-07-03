/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * key for this problem is to elimaniate 3 unknowns to only having 2 unknowns to get the Complexity fron n^3 to n^2.
 * Complexity : O(N^2) time, O(1) space
 */
public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int result = 0;
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      int sum = target - nums[i];
      j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (nums[j] + nums[k] >= sum) {
          k--;
        } else {
          result += k - j;
          j++;
        }
      }
    }
    return result;
  }
}
