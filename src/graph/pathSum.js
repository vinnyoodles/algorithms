/**
 * Given a tree, return true if there exists a path where the sum equals k.
 *
 * @param  {TreeNode} root
 * @param  {Int} k
 * @return {Boolean}
 */
function pathSum(root, k) {
  if (!root) return false;
  else if (root.value === k && root.isLeaf()) return true;

  return pathSum(root.left, k - root.value) || pathSum(root.right, k - root.value);
}

module.exports = pathSum;
