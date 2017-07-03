/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return head;
    ListNode temp = new ListNode(-1);
    temp.next = head;
    ListNode pre = temp;
    ListNode cur = head;
    while (cur != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
      }

      if(pre.next == cur) {
        pre = pre.next;
      } else {
        pre.next = cur.next;
      }
      cur = cur.next;
    }
    return temp.next;
  }
}

