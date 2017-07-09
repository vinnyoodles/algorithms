/**
 * Given a non-empty binary tree, return the average value of the nodes on each level 
 * in the form of an array.
 */
public class Solution {
  public List<Double> averageOfLevels(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<Double> list = new ArrayList<Double>();
    queue.add(root);

    int cur = 1;
    int count = 1;
    int next = 0;
    double sum = 0;

    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      cur --;
      sum += node.val;

      if (node.left != null) {
        next ++;
        queue.add(node.left);
      }

      if (node.right != null) {
        next ++;
        queue.add(node.right);
      }

      if (cur == 0) {
        cur = next;
        list.add(sum / count);
        count = next;
        next = 0;
        sum = 0;
      }
    }

    return list;
  }
}