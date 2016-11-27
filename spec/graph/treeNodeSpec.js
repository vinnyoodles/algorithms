var TreeNode = require('../../src/graph/TreeNode');

describe('TreeNode', () => {
  describe('constructor', () => {
    it('should create a tree node', () => {
      var node = new TreeNode(1);
      expect(typeof node).toEqual('object');
      expect(node.value).toEqual(1);
      expect(typeof node.left).toEqual('object');
      expect(typeof node.right).toEqual('object');
    });

    it('should create a tree with an array', () => {
      var node = new TreeNode([1, 2, 3, 4, 5]);
      expect(node.inOrder()).toEqual([1, 2, 3, 4, 5]);
    });

    it('should create an empty node with no values', () => {
      var node = new TreeNode([]);
      expect(typeof node).toEqual('object');
      expect(node.value).toEqual(undefined);
    });
  });

  describe('traversal', () => {
    beforeEach(() => {
      this.root = new TreeNode([1, 2, 3, 4, 5, 6, 7]);
    });

    describe('pre order', () => {
      it('should print the tree in pre order', () => {
        expect(this.root.preOrder()).toEqual([4, 2, 1, 3, 6, 5, 7]);
      });
    });

    describe('in order', () => {
      it('should print the tree in in order', () => {
        expect(this.root.inOrder()).toEqual([1, 2, 3, 4, 5, 6, 7]);
      });
    });

    describe('post order', () => {
      it('should print the tree in post order', () => {
        expect(this.root.postOrder()).toEqual([1, 3, 2, 5, 7, 6, 4]);
      });
    });
  });

  describe('isLeaf', () => {
    it('should return false if the node doesn\'t exist', () => {
      var node = new TreeNode(1);
      node.value = null;
      expect(node.isLeaf()).toEqual(false);
    });

    it('should return true if the node is a leaf node', () => {
      var node = new TreeNode(1);
      expect(node.isLeaf()).toEqual(true);
    });

    it('should return false with a left child', () => {
      var node = new TreeNode(1);
      node.left = new TreeNode(2);
      expect(node.isLeaf()).toEqual(false);
    });

    it('should return false with a right child', () => {
      var node = new TreeNode(1);
      node.right = new TreeNode(2);
      expect(node.isLeaf()).toEqual(false);
    });
  });
});
