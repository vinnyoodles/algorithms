# This problem was asked by Google.
# A unival tree (which stands for "universal value") is a tree where all nodes have the same value.
# Given the root to a binary tree, count the number of unival subtrees.

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def unival(root):
    count = [0]
    helper(root, count)
    return count[0]

def helper(node, count):
    if node is None:
        return True
    left = helper(node.left, count)
    right = helper(node.right, count)

    if left and right and node.left != None and node.right != None and node.left.val == node.val and node.right.val == node.val:
        count[0] += 1
        return True

    return False