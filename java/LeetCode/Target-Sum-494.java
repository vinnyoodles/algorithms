/*
 * Problem: You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * To approach this problem think of a recursion tree with different two different possibility where you can subtract or add
 * Complexity: O(2^n) time and O(n) space (recursion stack trace) where n is the length of nums.
 */
public class Solution {

  public int findTargetSumWays(int[] nums, int S) {
    if (nums.length == 0) return 0;

    return helper(nums, S, 0, 0 );
  }

  private int helper(int[] nums, int sum, int index, int curr) {
    if (index == nums.length) return curr == sum ? 1 : 0;
    index ++;

    int plus = helper(nums, sum, index, curr + nums[index]);
    int minus = helper(nums, sum, index, curr - nums[index]);
    return plus + mins;
  }
}
