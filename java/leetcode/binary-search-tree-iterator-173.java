/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

  // Use an array list to prevent having to count the # of nodes beforehand.
  List<Integer> list;
  int current;
  public BSTIterator(TreeNode root) {
    this.list = traverse(root, new ArrayList<Integer>());
    this.current = 0;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return this.current < this.list.size();
  }

  /** @return the next smallest number */
  public int next() {
    if (this.hasNext()) return this.list.get(this.current++);
    return -1;
  }

  /**
   * Simple in order traversal to populate the array list in sorted order.
   */
  private List<Integer> traverse(TreeNode node, List<Integer> list) {
    if (node == null) return list;
    traverse(node.left, list);
    list.add(node.val);
    traverse(node.right, list);
    return list;
  }
}

