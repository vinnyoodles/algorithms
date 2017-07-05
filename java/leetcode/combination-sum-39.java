/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 */
public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    helper(candidates, target, list, new ArrayList<Integer>(), 0);
    return list;
  }

  public void helper(int[] arr, int target, List<List<Integer>> list, List<Integer> cur, int index) {
    if (target == 0) {
      list.add(new ArrayList<Integer>(cur));
      return;
    }
    if (target < 0) return;
    for (int i = index; i < arr.length; i ++) {
      cur.add(arr[i]);
      helper(arr, target - arr[i], list, cur, i);
      cur.remove(cur.size() - 1);
    }
  }
}