function ListNode(value) {
  this.next = null;
  this.value = value;
}

/**
 * Add the value or values to the end of the list.
 *
 * @param {ListNode} clone the last node that has been added.
 */
ListNode.prototype.append = function(values) {
  if (typeof values === 'number') values = [values];

  var clone = this;

  // Traverse to the end of the list.
  while (clone.next) { clone = clone.next; }

  for (var i in values) {
    clone = clone.next = new ListNode(values[i]);
  }

  return clone;
};

/**
 * Return the linked list as an array of each nodes' value.
 * @return {Array}
 */
ListNode.prototype.toArray = function() {
  var clone = this;
  var array = [];

  while (clone) {
    if (typeof clone.value === 'number') array.push(clone.value);
    clone = clone.next;
  }

  return array;
};

/**
 * Find the given node in the linked list.
 * If found return the node before it.
 * If not found, then return null
 *
 * @param {ListNode} searchNode
 * @return {ListNode}
 */
ListNode.prototype.findNode = function(searchNode) {
  var clone = this;

  while (clone) {
    if (clone.next === searchNode) {
      return clone;
    }

    clone = clone.next;
  }

  return null;
};

/**
 * Remove the last node from the list.
 *
 * @return {ListNode} node return the removed mode.
 */
ListNode.prototype.removeLast = function() {
  var clone = this;
  var prevNode;

  // Traverse to the end;
  while (clone.next) {
    prevNode = clone;
    clone = clone.next;
  }

  // If the list is less than 2 nodes, remove the last node and return.
  if (!prevNode) {
    this.value = null;
    return clone;
  }

  prevNode.next = null;
  return clone;

};

module.exports = ListNode;
