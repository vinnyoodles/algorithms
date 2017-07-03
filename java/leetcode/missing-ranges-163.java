/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * Note when doing this problem be careful with overflow since input could be a Integer.MaxValue.
 * Complexity : O(N) time, O(N) space (the solution list)
 */
public class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<String>();
    int range = lower;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > range) {
        res.add(getValidRange(range, nums[i] - 1));
      }
      if (upper == nums[i]) { // avoid the overflow so return the result;
        return res;
      }
      range = nums[i] + 1;
    }
    if (range <= upper) {
      res.add(getValidRange(range, upper));
    }
    return res;
  }

  private String getValidRange(int lower, int upper) {
    return upper > lower ? String.format("%d->%d", lower, upper) : lower + "";
  }
}
