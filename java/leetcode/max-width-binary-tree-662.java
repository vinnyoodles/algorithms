public int widthOfBinaryTree(TreeNode root) {
  if (root == null) {
    return 0;
  }

  Queue<TreeNode> q = new LinkedList<>();
  Queue<Integer> indices = new LinkedList<>();
  q.add(root);
  indices.add(1);
  int cur = 1;
  int next = 0;
  int left = 0;
  int max = 0;
  boolean firstLeft = true;

  while (!q.isEmpty()) {
    TreeNode node = q.poll();
    int index = indices.poll();
    cur --;

    // First left node.
    if (firstLeft) {
      left = index;
      firstLeft = false;
    }

    if (node.left != null) {
      q.add(node.left);
      columns.add(col * 2);
      next ++;
    }

    if (node.right != null) {
      q.add(node.right);
      columns.add(col * 2 + 1);
      next ++;
    }

    // Last right node.
    if (cur == 0) {
      cur = next;
      next = 0;
      max = Math.max(max, index + 1 - left);
      left = 0;
      firstLeft = true;
    }
  }

  return max;
}
