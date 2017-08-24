/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

/** Iterative version **/
public List<Integer> inorderTraversal(TreeNode root) {
  Stack<TreeNode> stack = new Stack<>();
  HashSet<TreeNode> set = new HashSet<>();
  List<Integer> list = new ArrayList<>();
  stack.push(root);
  set.add(root);
  if (root == null) return list;

  while (!stack.isEmpty()) {
    TreeNode node = stack.pop();
    if (node == null) {
      continue;
    }

    TreeNode left = node.left;
    TreeNode right = node.right;
    boolean hasLeft = false;
    if (left != null && !set.contains(left)) {
      // Push the current node back into the stack because if left exists then 
      // it will not be added in this current iteration
      stack.push(node);
      hasLeft = true;
    }

    while (left != null) {
      if (!set.contains(left)) {
        stack.push(left);
        set.add(left);
      }                    
      left = left.left;
    }

    if (hasLeft) {
      // We have to stop the current iteration to add all the left nodes first. 
      continue;
    }

    list.add(node.val);

    if (node.right != null) {
      stack.push(node.right);
    }
  }

  return list;
}
