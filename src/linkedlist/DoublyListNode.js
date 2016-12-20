var ListNode = require('./ListNode');

function DoublyListNode(value) {
  if (value === undefined || value === null) throw new TypeError('Invalid DoublyListNode value');
  else if (typeof value === 'number') value = [value];

  this.value = value.shift();
  this.prev = null;
  while (value.length) {
    var next = this.next = new DoublyListNode(value);
    next.prev = this;
  }
}

DoublyListNode.prototype = ListNode.prototype;
DoublyListNode.prototype.constructor = DoublyListNode;

/**
 * Remove the current node from its position in the list.
 *
 * @return {DoublyListNode}
 */
DoublyListNode.prototype.removeFromList = function() {
  var node = this;

  if (node.prev) node.prev.next = node.next;
  if (node.next) node.next.prev = node.prev;

  node.next = node.prev = null;
  return node;
};

module.exports = DoublyListNode;
