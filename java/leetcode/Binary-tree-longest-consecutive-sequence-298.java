/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *   1
 *    \
 *    3
 *   / \         output : Longest consecutive sequence path is 3-4-5, so return 3.
 *  2   4
 *       \
 *        5
 * Complexity : Time O(n), Space O(N)
 */

public class Solution {
  public int longestConsecutive(TreeNode root) {
    int max = 1;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    if (root == null) return 0;
    q.add(root);
    Queue<Integer> countTrack = new LinkedList<Integer>(); // mutiple childern could have same path
    // so we need to make sure we don't double count.
    countTrack.add(1); // for the root
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        int count = countTrack.poll();

        if (node.left != null) {
          q.add(node.left);
          // we know if it's a start of a sequence if the statement is valid
          if (node.left.val == node.val + 1) {
            countTrack.add(count + 1);
            max = Math.max(max, count + 1);
          } else {
            countTrack.add(1);
          }
        }
        if (node.right != null) {
          q.add(node.right);
          if (node.right.val == node.val + 1) {
            max = Math.max(max , count + 1);
            countTrack.add(count + 1);
          } else {
            countTrack.add(1);
          }
        }
      }
    }
    return max;
  }
}
