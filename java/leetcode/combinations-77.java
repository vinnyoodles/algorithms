/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i ++) {
      arr[i] = i + 1;
    }

    List<List<Integer>> list = new ArrayList<List<Integer>>();
    helper(arr, 0, list, new ArrayList<Integer>(), k);
    return list;
  }

  public void helper(int[] nums, int index, List<List<Integer>> list, List<Integer> cur, int k) {
    // The base case is to add the current set.
    if (cur.size() == k) list.add(new ArrayList<Integer>(cur));
    for (int i = index; i < nums.length; i ++) {
      // Add the next value.
      cur.add(nums[i]);
      // Find all potential subsets building off the current set.
      helper(nums, i + 1, list, cur, k);
      // Backtrack by removing the current value.
      cur.remove(cur.size() - 1);
    }
  }
}