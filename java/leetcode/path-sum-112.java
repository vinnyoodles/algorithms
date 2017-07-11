
/**
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that adding up 
 * all the values along the path equals the given sum.
 */
public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (isLeaf(root)) {
      return sum == root.val;
    }

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

  public boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}