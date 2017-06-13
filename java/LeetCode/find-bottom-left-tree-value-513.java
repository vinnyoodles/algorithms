/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Solution:
 * Use bfs to reach every node.
 * Use different counters/variables to keep track of the first/left most node in every level.
 * Complexity: O(n) time and space where n is the # of nodes in the tree.
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int current = 1;
        int next = 0;
        int left = root.val;
        int childCount = -1;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (next == 0 && ((current > 1 && current == childCount) || (current == 1 && childCount == 1))) {
                left = node.val;
            }
            current --;

            if (node.left != null) {
                queue.add(node.left);
                next ++;
            }

            if (node.right != null) {
                queue.add(node.right);
                next ++;
            }

            if (current == 0) {
                current = next;
                childCount = next;
                next = 0;
            }
        }

        return left;
    }
}

//Version 2
/**
 * Complexity: O(n) time and O(n) space using a BFS approach.
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      int totalNodes = 1;

      TreeNode res = root;
      queue.add(root);
      while (!queue.isEmpty()) {
        for (int i = 0; i < queue.size(); i++) {
          TreeNode node = queue.poll();
          if (node.left != null) {
            queue.add(node.left);
          }

          if (node.right != null) {
            queue.add(node.right);
          }

          if (i == 0) {
            res = node;
          }
        }
      }
      return res.val;
    }
}
