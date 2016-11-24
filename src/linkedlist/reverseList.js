var ListNode = require('./ListNode');

/**
 * Given a linked list, return a linked list in reverse order.
 *
 * @param  {ListNode} list
 * @return {ListNode}
 */
function reverseList(list) {
  var clone = new ListNode(-1);

  while(list) {
    var temp = new ListNode(list.value);
    temp.next = clone.next;
    clone.next = temp;
    list = list.next;
  }

  return clone.next;
}

module.exports = reverseList;
