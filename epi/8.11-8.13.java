/**
 * O(1) space and O(n) time complexity
 * 8.11
 */
public boolean isPalindrome(Node node) {
  int size = 1;
  Node listSize = node;
  while (listSize.next != null) {
    size++;
    listSize = listSize .next;
  }

  int middle = size/2;
  Node findMiddle = node;
  int counter = 0;

  if (size%2 != 0) {
    middle++;
  }

  while (counter < middle) {
    findMiddle = findMiddle.next;
    counter++;
  }

  Node middle = reverse(middle);

  while (middle.next != null) {
    if (node.element != middle.element) {
      return false;
    }
    node = node.next;
    middle = middle.next;
  }

  return true;
}

// reverse the linked list
private Node reverse(Node node) {

  Node temp;
  Node head = node;
  while (node.next != null) {
    temp = node.next;
    temp.next = head;
    head = temp;
    node = node.next;
  }
  return head;

}

/**
* 8.12
* O(1) space and O(n) time
* 5 - > 2 - > 3 - > 1 - > 8 pivot  = 3
* 2 - > 1 -> 3 -> 5 -> 8
*/
public Node pivotList(Node node, int pivot) {
    // Create the linked lists for the partitioning.
    // These three pointers will be used for creating the 3 lists.
    Node left = new Node(-1);
    Node pivot = new Node(-1);
    Node right = new Node(-1);

    // Also, keep 3 more pointers at the head of each lists for combining later.
    // These pointers never move.
    Node leftHead = left;
    Node pivotHead = pivot;
    Node rightHead = right;

    while (node.next != null) {
        if (node.element < pivot) {
            left.next = node;
            left = left.next;
        } else if ( node.element > pivot) {
            right.next = node;
            right = right.next;
        } else {
            pivot.next = node;
            pivot = pivot.next;
        }

        node = node.next;
    }

    left.next = pivotHead.next;
    pivot.next = rightHead.next;
    right.next = null;

    return leftHead.next;
}

/**
* 8.13
* get the sum of two linked list
* O(1) space and O(max(list1, list2)) time
*/
public Node ListSum(Node list1, Node list2){
    // 1 -> 2 - 3
    // 9 -> 8 -> 4 - > 5
    // 0 -> 1 -> 8 -> 5
    Node sum = new Node(-1);
    int carry = 0;
    while (list1 != null || list2 != null){
        Node temp = list1 == null ? list2 : list1;
        int sumVal = ( list1 != null ? list1.element : 0 ) +
            ( list2 != null ? list2.element : 0 ) + carry;
        int rem = sum%10;
        carry = sum/10;
        temp.element = rem;
        sum.next = temp;
        sum = sum.next;

        list1 = list1 != null ? list1.next : list1;
        list2 = list2 != null ? list2.next : list2;

    }
    if (carry != 0){
        Node temp = new Node(-1);
        temp.element = carry;
        sum.next = temp;
        sum = sum.next;
    }
    return sum.next;

}
