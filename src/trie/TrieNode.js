var assert = require('assert');

/**
 * A single node that represents a letter in the trie structure.
 *
 * @param {String} letter
 */
function TrieNode(letter) {
  assert(letter.length === 1, 'letter must be a single character');
  this.letter = letter;
  // Store each trie node's children using a table indexed by the letters.
  this.children = {};
  // A boolean value to mark if the current partial string is a complete string.
  this.complete = false;
  // Keep track of the complete words that this node is a part of.
  this.matches = [];
}

TrieNode.prototype.toArray = function(array) {
  if (this.complete) array.push(...this.matches);
  for (var i in this.children) {
    this.children[i].toArray(array);
  }
  return array;
}

module.exports = TrieNode;
