/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    int countA = 1;
    int countB = 1;
    ListNode cloneA = headA;
    ListNode cloneB = headB;

    while (cloneA.next != null || cloneB.next != null) {
      if (cloneA.next != null) {
        cloneA = cloneA.next;
        countA ++;
      }

      if (cloneB.next != null) {
        cloneB = cloneB.next;
        countB ++;
      }
    }

    if (cloneA != cloneB) return null;

    ListNode longer = countA > countB ? headA : headB;
    ListNode shorter = countA > countB ? headB : headA;
    for (int i = 0; i < Math.abs(countA - countB); i ++) {
      longer = longer.next;
    }

    while (longer != shorter) {
      longer = longer.next;
      shorter = shorter.next;
    }
    return longer;
  }
}