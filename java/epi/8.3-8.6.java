public class Node <T> {
  public Node <T> next;
  public T element;

  public Node (T t) {
    this.element = t;
  }
}

/**
 * EPI: 8.3
 * Given a linked list:
 * return true if a cycle exists.
 * return false otherwise
 */
public boolean hasCycle(Node node) {
  Node fast = node;
  Node slow = node;
  while (fast.next != null && fast.next.next != null) {

    fast = fast.next.next;
    slow = slow.next;

    if (fast == slow) {
      return true;
    }
  }
  return false; 
}

/**
 * EPI: 8.35 (Variant)
 * Given a linked list, return the beginning node of the cycle.
 * If a cycle does not exist then return null.
 */
public Node hasCycle(Node node) {
  Node fast = node;
  Node slow = node;
  Node head = node;
  while (fast.next != null && fast.next.next != null) {

    fast = fast.next.next;
    slow = slow.next;

    // Found intersection point, therefore cycle exists.
    if (fast == slow) {
      // The beginning of the cycle is equidistant
      // from the head of the linked list and the intersection point.
      while (head != fast) {
        head = head.next;
        fast = fast.next;
      }
      return head;
    }
  }
  return null; 
}

/**
 * EPI: 8.4
 * Given two linked lists, return true if there are any nodes that exist in both lists.
 * Return false if no equal node exists in both.
 */
public boolean hasEqualNode(Node a, Node b) {
  while (a.next != null || b.next != null) {data
    a = a.next == null ? a : a.next; 
    b = b.next == null ? b : b.next;
  }

  return a == b; 
}

/**
 * EPI: 8.45 (Variant)
 * Given two linked lists, return the first node that exists in both (where the merge occurs).
 * If no node exists, then return null.
 */
public Node hasEqualNode(Node a, Node b) {
  int sizeA = 1;
  int sizeB = 1;

  while (a.next != null || b.next != null) {
    if (a.next != null) {
      sizeA ++;
      a = a.next;
    }

    if (b.next != null) {
      sizeB ++;
      b = b.next;
    }
  }

  Node longer = a > b ? a : b; 
  Node shorter = a > b ? b : a;
  int diff = Math.abs(sizeA - sizeB);

  // Trash the first diff nodes in the longer list.
  for (int i = 0; i < diff; i ++)
    longer = longer.next;

  // Now compare the two lists now that they are equal lengths.
  while(longer.next != null) {
    if (longer == shorter) return longer;

    longer = longer.next;
    shorter = shorter.next;
  }
  return null;
}

/**
 * EPI: 8.6
 * Given a linked list node, delete that node from the list.
 * The given node may or may not be the head node, but you'll never be given the last node.
 */
public void deleteLinkedListNode(Node node){
  node.element = node.next.element;
  node.next = node.next.next;
}
