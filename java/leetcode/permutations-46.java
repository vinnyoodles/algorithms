/**
 * Given a list of distinct numbers, return all possible permutations.
 */
public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    helper(nums, 0, permutations, new ArrayList<Integer>());
    return permutations;
  }

  public void helper(int[] nums, int index, List<List<Integer>> list, List<Integer> cur) {
    // Permutations are same size of nums, just different ordering.
    if (nums.length == cur.size()) list.add(new ArrayList<Integer>(cur));

    for (int i = index; i < nums.length; i ++) {
      cur.add(nums[i]);
      // Move the one that was just added out of the potential options to prevent duplicates.
      if (i != index) swap(nums, i, index);
      helper(nums, index + 1, list, cur);

      // Move back to find different unique orderings.
      if (i != index) swap(nums, i, index);
      cur.remove(cur.size() - 1);
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}