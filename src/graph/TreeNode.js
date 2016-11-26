/**
 * Creates a binary tree node.
 * Supports creating an entire tree if the parameter is an array.
 * The tree will be created using an in order traversal.
 *
 * @param  {Int/Array} values
 * @return {TreeNode} root node.
 */
function TreeNode(values) {
  if (typeof values === 'number') values = [values];

  // Return if there are no values.
  else if (!values.length) return;

  var midpoint = Math.floor(values.length / 2);
  var nodeValue = values[midpoint];
  this.value = nodeValue;
  this.left = new TreeNode(values.slice(0, midpoint));
  this.right = new TreeNode(values.slice(midpoint + 1));
}

TreeNode.prototype.preOrder = function(array) {
  if (!this) return [];

  array = array || [];

  if (this.value) array.push(this.value);
  if (this.left) array.concat(this.left.preOrder(array));
  if (this.right) array.concat(this.right.preOrder(array));

  return array;
};

TreeNode.prototype.inOrder = function(array) {
  if (!this) return [];

  array = array || [];

  if (this.left) array.concat(this.left.inOrder(array));
  if (this.value) array.push(this.value);
  if (this.right) array.concat(this.right.inOrder(array));

  return array;
};

TreeNode.prototype.postOrder = function(array) {
  if (!this) return [];

  array = array || [];

  if (this.left) array.concat(this.left.postOrder(array));
  if (this.right) array.concat(this.right.postOrder(array));
  if (this.value) array.push(this.value);

  return array;
};

module.exports = TreeNode;
