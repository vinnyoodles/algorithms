/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, 
 * but it must go downwards (traveling only from parent nodes to child nodes).
 */
public class Solution {
  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    return helper(root, sum, sum, 0);
  }

  public int helper(TreeNode node, int sum, int original, int count) {
    if (node == null) return count;
    if (sum == node.val) count ++;

    int left = helper(node.left, sum - node.val, original, count);
    int right = helper(node.right, sum - node.val, original, count);
    int startLeft = helper(node.left, original - node.val, original, count);
    int startRight = helper(node.right, original - node.val, original, count);
    return left + right;
  }
}