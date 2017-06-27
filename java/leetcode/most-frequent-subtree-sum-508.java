/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * 
 * Solution: Use DFS + recursion and hashmap to maintain frequency
 * Complexity: O(N) time and space.
 */
public class Solution {
  public int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) return new int[0];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    populateMap(root, map);
    int max = 0;
    for (int i : map.keySet()) {
      max = Math.max(max, map.get(i));
    }

    List<Integer> list = new ArrayList<Integer>();
    for (int i : map.keySet()) {
      if (map.get(i) == max) list.add(i);
    }

    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i ++) res[i] = list.get(i);
    return res;
  }

  public int populateMap(TreeNode node, HashMap<Integer, Integer> map) {
    if (node == null) return 0;
    if (node.left == null && node.right == null) {
      map.put(node.val, map.getOrDefault(node.val, 0) + 1);
      return node.val;
    }
    int left = populateMap(node.left, map);
    int right = populateMap(node.right, map);
    int sum = left + right + node.val;
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
  }
}