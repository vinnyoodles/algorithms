var DoublyListNode = require('../linkedlist/DoublyListNode');

function LRUCache(size) {
  // The maximum size of the cache.
  this.size = size;

  // Private table that maps the key to the node in the linked list.
  this._nodeTable = {};

  // Private list node that represents the start of the list.
  this._head = null;

  // Private list node that represents the end of the list.
  this._tail = null;

  // Private interger that represents the current size of the cache.
  this._currentSize = 0;
}
/**
 * Return the value stored under the key.
 * Return null if the value does not exist.
 * Also, update the key/value pair to the front of the cache
 * to mark it as recently used.
 *
 * @param  {String} key
 */
LRUCache.prototype.get = function(key) {
  // The value does not exist in either tables.
  if (!this._nodeTable[key]) return null;

  // Get the current node and move it to the front of the list.
  var node = this._nodeTable[key];
  this._update(node);

  return node.value;
};

/**
 * Add the key value pair to the cache.
 * If the cache is full, then evict the least recently used node to make room.
 *
 * @param {String} key
 * @param {Any} value
 */
LRUCache.prototype.set = function(key, value) {
  // If the list is currently empty
  if (!this._head) {
    this._nodeTable[key] = this._tail = this._head = new DoublyListNode(value);
    this._currentSize ++;
    return;

  // Only remove the last node if the size is reached and the key is new.
  } else if (this._currentSize >= this.size && !this._nodeTable[key]) {
    // Evict the least recently used node (the tail of the list).
    var tailNode = this._tail;
    tailNode.prev.next = null;
    this._tail = tailNode.prev;
    // Remove the key/value pair from the table as well.
    for (var _key in this._nodeTable) {
      if (this._nodeTable[_key] === tailNode) delete this._nodeTable[_key];
    }

    this._currentSize --;
  }

  if (this._nodeTable[key]) {
    // If the key is already being used in the table,
    // then update the value and move the node to the head of the list.
    var node = this._nodeTable[key];
    node.value = value;
    this._update(node);
  } else {
    // Add the node to the front of the list.
    var newNode = new DoublyListNode(value);
    this._update(newNode);
    // Add the node to the table under the key.
    this._nodeTable[key] = newNode;
    this._currentSize ++;
  }
};

LRUCache.prototype._update = function(node) {
  // If the node is the head node, then return.
  if (node === this._head) return;
  // If there is only 1 node in the list.
  else if (this._head === this._tail) {
    node.next = this._tail;
    this._tail.prev = node;
    this._head = node;
    return;
  }

  var prevNode = node.prev;

  // If the node does not exist in the list, then add as the head (new node).
  if (!prevNode) {
    node.next = this._head;
    this._head.prev = node;
    this._head = node;
    return;
  }

  // If the node that is being updated is the tail, then we must set a new tail.
  if (this._tail === node) {
    prevNode.next = null;
    this._tail = prevNode;
  } else {
    prevNode.next = node.next;
    node.next.prev = prevNode;
  }
  node.prev = null;
  node.next = this._head;
  this._head.prev = node;
  this._head = node;
};

module.exports = LRUCache;
