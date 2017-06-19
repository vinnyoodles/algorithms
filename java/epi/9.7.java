/**
 * class TreeNode {
 *   TreeNode left;
 *   TreeNode right;
 *   int element;
 * }
 *
 * Given a tree with the structure above, create a list for every depth of the tree
 * and return all the lists.
 */
public List<List<Integer>> binaryTreeDepthList(TreeNode root) {
  // Safety check.
  if (root == null) return null;

  Queue<Integer> queue = new Queue<Integer>();
  // Nested list in the resultant list.
  List<Integer> current = new ArrayList<Integer>();
  // The resultant list.
  List<List<Integer>> result = new ArrayList<List<Integer>>();

  // Keep track of the number of nodes we have currently visited
  // that are in the same depth/level.
  int currentNodes = 1;
  // Keep track of the number of nodes in the same depth/level.
  int nextNodes = 0;

  queue.enqueue(root);
  while (!queue.isEmpty()) {
    TreeNode node = queue.dequeue();
    current.add(node.element);
    currentNodes --;

    if (node.left != null) {
      queue.enqueue(node.left);
      nextNodes ++;
    }

    if (node.right != null) {
      queue.enqueue(node.right);
      nextNodes ++;
    }

    // All the nodes in that current level have been visited so reset the counters.
    if (currentNodes == 0) {
      // Transfer the count of the next depth to the current count since
      // we are now moving to the next depth. 
      currentNodes = nextNodes;

      // There is a count of 0 nodes in the next next depth as we have not touched that level yet.
      nextNodes = 0;

      // Add the current list to the resultant and reset the current list.
      result.add(current);
      // Reinitialize a new list so we do not mutate the old ones.
      current = new ArrayList<Integer>();
    }
  }

  return result;
}