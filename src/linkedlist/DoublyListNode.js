function DoublyListNode(value) {
  this.next = null;
  this.prev = null;
  this.value = value;
}

/**
 * Return the linked list as an array of each nodes' value.
 * @return {Array}
 */
DoublyListNode.prototype.toArray = function() {
  var clone = this;
  var array = [];

  while (clone) {
    if (typeof clone.value === 'number') array.push(clone.value);
    clone = clone.next;
  }

  return array;
};

module.exports = DoublyListNode;
