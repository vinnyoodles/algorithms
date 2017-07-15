/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * pretty cute problem to do. Key for this is to draw the sort yourself, helps with writing the algo out.
 * Complexity : O(nlog(n)) time, O(1) space
 */

public class Solution {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i+=2){
      int swap = i + 1;
      if (i + 1 < nums.length) {
        int temp = nums[i];
        nums[i] = nums[swap];
        nums[swap] = temp;
      }
    }
  }
}
