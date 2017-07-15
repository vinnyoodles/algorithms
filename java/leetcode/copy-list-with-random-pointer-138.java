/**
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) return null;

    HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    RandomListNode temp = head;

    // Populate the map and instantiate all new nodes.
    while (temp != null) {
      map.put(temp, new RandomListNode(temp.label));
      temp = temp.next;
    }

    temp = head;
    RandomListNode newHead = new RandomListNode(-1);
    RandomListNode anotherNode = newHead;
    while (temp != null) {
      RandomListNode clone = map.get(temp);
      newHead.next = clone;
      RandomListNode random = temp.random;

      // Assign the random pointer, if it exists.
      if (random != null) newHead.next.random = map.get(random);
      temp = temp.next;
      newHead = newHead.next;
    }

    return anotherNode.next;
  }
}