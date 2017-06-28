/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Including the null set.
 */
public List<List<Integer>> subsets(int[] nums) {
  List<List<Integer>> list = new ArrayList<List<Integer>>();
  helper(nums, 0, list, new ArrayList<Integer>());
  return list;
}

public void helper(int[] nums, int index, List<List<Integer>> list, List<Integer> cur) {
  // The base case is to add the current set.
  list.add(new ArrayList<Integer>(cur));
  for (int i = index; i < nums.length; i ++) {
    // Add the next value.
    cur.add(nums[i]);
    // Find all potential subsets building off the current set.
    helper(nums, i + 1, list, cur);
    // Backtrack by removing the current value.
    cur.remove(cur.size() - 1);
  }
}

