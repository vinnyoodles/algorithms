/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class Solution {
  public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    if (nums.length == 0) return;
    while (j < nums.length) {
      if (nums[j] == 0) {
        j++;
        continue;
      }

      nums[i] = nums[j];
      i ++;
      j ++;
    }
    for (;i < nums.length; i ++) nums[i] = 0;
  }
}