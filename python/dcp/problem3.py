# This problem was asked by Google.
# Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
# and deserialize(s), which deserializes the string back into the tree.

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def serialize(root):
    if root:
        string = '{0},'.format(root.val)
        string = string + serialize(root.left)
        string = string + serialize(root.right)
        return string
    else:
        return 'X,'
    

def deserialize(data):
    if len(data) < 1:
        return None
    queue = [x.strip() for x in data.split(',')]
    return helper(queue)

def helper(queue):
    if len(queue) < 1:
        return None
    val = queue.pop(0)
    if val == 'X':
        return None
    else:
        node = TreeNode(int(val))
        node.left = helper(queue)
        node.right = helper(queue)
        return node

data = '1,2,X,X,3,4,X,X,5,X,X,'
assert(data == serialize(deserialize('1,2,X,X,3,4,X,X,5,X,X,')))