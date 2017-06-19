// 2 -> 3 -> 5 -> 3 -> 2  K = 3
// 2 -> 2 -> 3 -> 5 -> 3  1 cycle
// 3 -> 2 -> 2 -> 3 -> 5  2 cycle
// 5 -> 3 -> 2 -> 2 -> 3  3 cycle result LinkedList
/**
 * Implement a right cyclic shift
 * Runs in O(n) time with no extra space
 */
public Node cyclicRightShift(Node node, int k){

    Node kMinusNode = node;
    Node kNode = new Node();
    Node head = node;
    int counter = 1;

    // Find the kth - 1 node
    while (counter < k - 1) {
       kMinusNode = kMinusNode.next;
       counter++;
    }

    // Remove the kth - 1 node's pointer to make it the new tail.
    kNode = kMinusNode.next;
    Node resultNode = kNode;
    kMinusNode.next = null;

    // Find the original tail and point it to the original head to keep the list whole.
    while (kNode.next != null) {
        kNode = kNode.next;
    }
    kNode.next = head;

    return resultNode;

}

// l0 - > l1  -> l2 -> l3 -> l4 -> l5
// odd = l1 -> l3 -> l5
// even = l0 -> l2 -> l4
// result = l0 - > l2 -> l4 -> l1 -> l3 -> l5
// runs in O(n) time with of O(1) space
public evenOddMerge(Node node){

    Node even = node;
    Node result = even;

    if (node.next == null) {
        return node;
    }

    Node odd = node.next;
    Node headOdd = odd;
    int counter = 1;

    if (node.next.next != null) {
        node = node.next.next;
    }

    while (node.next != null) {
         counter++;
         int modVal = counter%2;
         if (modVal == 0) {
             even.next = node;
             even = even.next;
         } else {
             odd.next = node;
             odd = odd.next;
         }
     node = node.next;
    }
    even.next = headOdd;
    return result;
}
