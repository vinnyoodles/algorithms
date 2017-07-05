/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
public class NumArray {

  int[] sums;
  public NumArray(int[] nums) {
    sums = new int[nums.length];
    n = nums;

    // Make a running sum array.
    for (int i = 0; i < nums.length; i ++) {
      if (i == 0) {
        sums[i] = nums[i];
      } else {
        sums[i] = nums[i] + sums[i - 1];
      }
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) return sums[j];
    if (i == j) return n[i];

    // If the range does not start at 0, then subtract the difference of the sum leading up to the beginning of the range.
    int diff = sums[i];
    return sums[j] - diff + n[i]; // Add back n[i] because the range is inclusive.
  }
}
