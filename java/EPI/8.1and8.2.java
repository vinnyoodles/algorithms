public class Node <T> {
  public Node <T> next;
  public T element;

  public Node (String key, T t) {
    this.element = t;
  }
}

/**
 * Given two sorted linked lists, merge the lists to a single sorted linked list.
 * Input: 1 -> 3 -> 5
 *        2 -> 4 -> 6
 * Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 **/
public Node mergeLinkedList(Node l1, Node l2){
    Node merge = new Node(-1);
    Node clone = merge;


    while(l1 != null || l2 != null) {
    int node1 = l1 == null ? Integer.MAX_VALUE : l1.element;
    int node2 = l2 == null ? Integer.MAX_VALUE : l2.element;
      if(node1 < node2) {
         merge.next = l1;
      } else {
         merge.next = l2;
      }

      merge = merge.next;
      l1 = l1.next;
      l2 = l2.next;

    }

    return clone.next;

}

/**
 * Given a linked lists, reverse the list from start to finish
 * The first node will be node 1
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12, 2, 5
 * Output: 2 -> 10 -> 8 -> 6 -> 4 -> 12
 */
public Node reverseSublist(Node node, int start, int finish){
    Node head = node;
    Node s;
    Node f;
    Node beforeS;
    Node afterf;
    int counter = 1;

    // Find s and f;
    while(node.next != null){
       if(counter == start - 1) {
           // Store s and the node before s for reattaching later
           s = node.next;
           beforeS = node;
        } else if(counter == finish) {
           f = node;
           afterF = node.next;
        }
        counter ++
        node = node.next;
    }

    // Cut off the end from f.
    f.next = null;
    s = reverseSublist(s);

    // Add back s from the front.
    beforeS = s;

    // Get the tail of s
    while(s.next != null) s = s.next;


    // Add back f from the rear.
    s.next = afterF;
    return head;
}

/**
 * Given a linked lists, reverse the list
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12
 * Output: 12 -> 10 -> 8 -> 6 -> 4 -> 2
 */
public Node reverseSublist(Node node) {
    Node reverse;
    Node temp;

    // Iterate through node, adding to the *tail* of reverse
    while (node.next != null) {
        temp = reverse;
        reverse = node;
        reverse.next = temp;


        node = node.next;
    }

    return reverse;
}
