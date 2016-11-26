function TreeNode(value) {
  this.left = this.right = null;
  this.value = value;
}

TreeNode.prototype.preOrder = function(array) {
  if (!this) return [];

  array = array || [];

  array.push(this.value);
  if (this.left) array.concat(this.left.preOrder(array));
  if (this.right) array.concat(this.right.preOrder(array));

  return array;
};

TreeNode.prototype.inOrder = function(array) {
  if (!this) return [];

  array = array || [];

  if (this.left) array.concat(this.left.inOrder(array));
  array.push(this.value);
  if (this.right) array.concat(this.right.inOrder(array));

  return array;
};

TreeNode.prototype.postOrder = function(array) {
  if (!this) return [];

  array = array || [];

  if (this.left) array.concat(this.left.postOrder(array));
  if (this.right) array.concat(this.right.postOrder(array));
  array.push(this.value);

  return array;
};

module.exports = TreeNode;
