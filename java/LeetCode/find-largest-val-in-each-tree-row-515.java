/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Complexity: O(N) time and space
 */
public class Solution {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if (root == null) return list;

    // Using BFS
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    // Counters for keeping track of depth.
    int cur = 1;
    int next = 0;

    // The current max for the current depth.
    int max = Integer.MIN_VALUE;

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      // Always update the max.
      max = Math.max(max, node.val);
      cur --;

      if (node.left != null) {
        queue.add(node.left);
        next ++;
      }

      if (node.right != null) {
        queue.add(node.right);
        next ++;
      }

      // The end of the level/depth has been reached
      // so update all counters and add the current max as well as resetting the max.
      if (cur == 0) {
        list.add(max);
        max = Integer.MIN_VALUE;
        cur = next;
        next = 0;
      }
    }

    return list;
  }
}
