var TreeNode = require('../../src/graph/TreeNode');

describe('TreeNode', () => {
  describe('traversal', () => {
    beforeEach(() => {
      // Level 1
      var root = this.root = new TreeNode(4);

      // Level 2
      var left = root.left = new TreeNode(2);
      var right = root.right = new TreeNode(6);

      // Level 3
      left.left = new TreeNode(1);
      left.right = new TreeNode(3);
      right.left = new TreeNode(5);
      right.right = new TreeNode(7);
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
});
