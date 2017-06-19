public class Solution {

  public boolean find132pattern(int[] nums) {
    // Keep track of the global minimum.
    // The global min will be the ai value.
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < nums.length; j++) {
      min = Math.min(nums[j], min);

      // If the current value is the minimum, 
      // then this is the ai value for this current iteration.
      if (min == nums[j]) continue;

      // Otherwise, it is not the minimum so let nums[j] be aj
      for (int k = nums.length - 1; k > j; k--) {

        // If there is a valid ak, after j then return true;
        if (min < nums[k] && nums[k] < nums[j]) return true;
      }
    }

    return false;
  }
}
