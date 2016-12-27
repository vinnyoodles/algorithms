function cyclical(node) {
  if (!node) return false;

  var runner = node;

  while (runner.next && runner.next.next) {
    node = node.next;
    runner = runner.next.next;

    if (node === runner) return true;
  }

  // If the list ever reaches the end, then there can't be a cycle.
  return false;
}

// This requires the node object to be mutable.
function mutatingCyclical(node) {
  while (node.next) {
    if (node.visited) return true;
    node.visited = true;
    node = node.next;
  }

  // If the list ever reaches the end, then there can't be a cycle.
  return false;
}

module.exports = cyclical;
