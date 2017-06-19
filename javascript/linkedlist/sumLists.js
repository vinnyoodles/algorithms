var ListNode = require('./ListNode');
/**
 * Given two linked lists, in reverse order, return a new list with the sum of the two lists.
 *
 * Example:
 * 1 -> 2 -> 3   (321)
 * 4 -> 5 -> 6   (654)
 * -------------------
 * 5 -> 7 -> 9   (975)
 *
 * @param  {ListNode} a
 * @param  {ListNode} b
 * @return {ListNode}
 */
function sumLists(a, b) {
  var sum = new ListNode(-1);
  var clone = sum;
  var carry = 0;

  while (a || b) {
    var currentSum = (a ? a.value : 0) + (b ? b.value : 0) + carry;
    if (currentSum > 9) {
      carry = 1;
      currentSum = currentSum - 10;
    } else {
      carry = 0;
    }

    clone = clone.next = new ListNode(currentSum);
    a = a ? a.next : a;
    b = b ? b.next : b;
  }

  if (carry) clone.next = new ListNode(carry);

  return sum.next;
}

module.exports = sumLists;
