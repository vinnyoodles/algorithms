/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. 
 * The root node is at depth 1.
 * The adding rule is: 
 *   given a positive integer depth d, for each NOT null tree nodes N in depth d - 1, create two tree nodes with value v as N's left subtree root and right subtree root. 
 *   And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. 
 *   If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
 */
public class Solution {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    // Edge case where we are adding a new root node.
    if (d == 1) {
      TreeNode temp = new TreeNode(v);
      temp.left = root;
      return temp;
    }

    int current = 1;
    int next = 0;
    int depth = 1;   // depth counter as we iterate

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      current --;

      if (d - 1 == depth) {
        // Store the left and right pointers to reattach.
        TreeNode left = node.left;
        TreeNode right = node.right;

        // Create the new row.
        node.left = new TreeNode(v);
        node.right = new TreeNode(v);

        // Reattach the old pointers to the new row.
        node.right.right = right;
        node.left.left = left;
      } else {
        if (node.left != null) {
          queue.add(node.left);
          next ++;
        }

        if (node.right != null) {
          queue.add(node.right);
          next ++;
        }
      }

      if (current == 0) {
        if (depth == d) return root;
        depth ++;
        current = next;
        next = 0;
      }
    }

    return root;
  }
}
