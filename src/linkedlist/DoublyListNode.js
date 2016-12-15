var ListNode = require('./ListNode');

function DoublyListNode(value) {
  this.next = null;
  this.prev = null;
  this.value = value;
}

DoublyListNode.prototype = ListNode.prototype;
DoublyListNode.prototype.constructor = DoublyListNode;

module.exports = DoublyListNode;
