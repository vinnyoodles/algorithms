function ListNode(value) {
  this.next = null;
  this.value = value;
}

ListNode.prototype.append = function(values) {
  if (typeof values === 'number') values = [values];

  var clone = this;

  for (var i in values) {
    clone = clone.next = new ListNode(values[i]);
  }
};

ListNode.prototype.toArray = function() {
  var clone = this;
  var array = [];

  while (clone) {
    array.push(clone.value);
    clone = clone.next;
  }

  return array;
};

module.exports = ListNode;
