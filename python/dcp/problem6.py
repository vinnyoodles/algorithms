# This problem was asked by Google.
# An XOR linked list is a more memory efficient doubly linked list.
# Instead of each node holding next and prev fields, it holds a field named both, which is a XOR of the next node and the previous node.
# Implement a XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
# If using a language that has no pointers (such as Python),
# assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

class ListNode(object):
    def __init__(self, element):
        self.element = element
        self.both = None

class XORLinkedList(object):
    def __init__(self):
        self.head = None
        self.size = 0

    def add(self, element):
        if self.head == None:
            self.head = ListNode(element)
            self.size += 1
            return

        # Get the tail node first
        tail = get(size - 1)
        node = ListNode(element)
        node.both = get_pointer(node)
        tail.both = tail.both ^ get_pointer(tail)
        self.size += 1


    def get(self, index):
        if index < 0 or index >= size
            return None

        node = self.head
        prev_p = 0
        for i in range(index):
            next_p = prev_p ^ node.both
            next_node = dereference_pointer(next_p)
            prev_p = next_node.both ^ get_pointer(node)
            node = next_node

        return node