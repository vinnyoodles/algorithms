/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

  /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
  ListNode node = null;
  public Solution(ListNode head) {
    this.node = head;

  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode head = node;
    ListNode res = node;
    int size = 0;
    while(head != null){
      size++;
      head = head.next;
    }
    int randomProb = (int)(Math.random() * size);
    for(int i = 0; i < randomProb; i++){
      res = res.next;

    }
    return res.val;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
