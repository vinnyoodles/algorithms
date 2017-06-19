var ListNode = require('./ListNode');

/**
 * Given two sorted lists, return a new list that contains
 * the nodes in each list in order.
 *
 * @param  {ListNode} a
 * @param  {ListNode} b
 * @return {ListNode}
 */
function mergeLists(a, b) {
  if (!a && !b) return null;
  var merged = new ListNode(-1);
  var clone = merged;

  while (a || b) {
    if ((a ? a.value : Number.MAX_VALUE) > (b ? b.value : Number.MAX_VALUE)) {
      merged.next = b;
      b = b ? b.next : b;
    } else {
      merged.next = a;
      a = a ? a.next : a;
    }

    merged = merged.next
  }

  return clone.next;
}

module.exports = mergeLists;
