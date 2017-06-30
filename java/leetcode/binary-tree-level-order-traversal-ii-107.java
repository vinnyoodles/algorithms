/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if (root == null) return list;

    List<Integer> temp = new ArrayList<Integer>();
    int cur = 1;
    int next = 0;
    q.add(root);

    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      temp.add(node.val);
      cur --;

      if (cur == 0 && !temp.isEmpty()) {
        list.add(0, temp);
        temp = new ArrayList<Integer>();
      }

      if (node.left != null) {
        q.add(node.left);
        next ++;
      }

      if (node.right != null) {
        q.add(node.right);
        next ++;
      }

      if (cur == 0) {
        cur = next;
        next = 0;
      }
    }

    return list;
  }
}
