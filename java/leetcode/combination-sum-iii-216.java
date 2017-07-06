/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination 
 * should be a unique set of numbers.
 */
public class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    helper(k, n, 1, list, new ArrayList<Integer>());
    return list;
  }
  
  void helper(int k, int n, int i, List<List<Integer>> list, List<Integer> cur) {
    if (n == 0 && cur.size() == k) {
      list.add(new ArrayList<Integer>(cur));
      return;
    } else if (n < 0) {
      return;
    }
    
    for (int index = i; index < 10; index ++) {
      cur.add(index);
      helper(k, n - index, index + 1, list, cur);
      cur.remove(cur.size() - 1);
    }
  }
}