var TreeNode = require('../../javascript/tree/TreeNode');
var columnSort = require('../../javascript/tree/columnSort');

describe('columnSort', () => {
  it('should return an array of the nodes\' value in column sorted order', () => {
    var node = new TreeNode([1, 2, 3, 4, 5, 6]);
    expect(columnSort(node)).toEqual([1, 2, 4, 3, 5, 6]);
  });

  it('should work for an empty tree', () => {
    var node = new TreeNode([]);
    expect(columnSort(node)).toEqual([]);
  });

  /**
   * Test with the following tree.
   *        5
   *       / \
   *      4   8
   *     /   / \
   *    9   6   4
   *   / \     / \
   *  7   2   5   1
   */
  it('should work for this tree', () => {
    var node = new TreeNode(5);
    node.left = new TreeNode(4);
    node.right = new TreeNode(8);
    node.left.left = new TreeNode([7, 9, 2]);
    node.right.left = new TreeNode(6);
    node.right.right = new TreeNode([5, 4, 1]);
    expect(columnSort(node)).toEqual([7, 9, 4, 2, 5, 6, 8, 5, 4, 1]);
  });

  it('should work for that tree', () => {
    var node = new TreeNode([7, 9, 2, 4, 5, 6, 8, 5, 4, 1]);
    expect(columnSort(node)).toEqual([7, 9, 2, 4, 8, 6, 5, 5, 4, 1]);
  });
});
