/**
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 * This problem took me a while to do the optimal solution without timing out, but the trick is to split the problem by doing
 * left to right, and then right to left.
 * Complexity : O(n) time, O(N) space
 */

public class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    Arrays.fill(res, 1);
    for (int i = 1; i < nums.length; i++) {
        res[i] = nums[i - 1] * res[i - 1];
    }
    int down = 1;
    for (int j = nums.length - 1; j >= 0; j--) {
        res[j] *= down;
        down *= nums[j];
    }
    return res;
  }
}
