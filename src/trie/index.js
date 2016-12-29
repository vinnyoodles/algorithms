var TrieNode = require('./TrieNode');

/**
 * Trie data structure for indexing a list of words
 * to be searched in a given text.
 *
 * @param {String} string optional
 */
function Trie(string) {
  this.root = new TrieNode('*');
  if (string) this.insert(string);
}

Trie.prototype.insert = function(word) {
  var node = this.root;
  // Iterate through each letter in the word.
  for (var i in word) {
    var char = word[i];
    // Check if this char exists in the current node.
    // If it doesn't exist, then add the node.
    if (!node.children[char]) node.children[char] = new TrieNode(char);

    // Move to the next node;
    node = node.children[char];
    node.matches.push(word);

    // If this is the last character, then mark the last node as complete
    if (i == word.length - 1) node.complete = true;
  }
};

Trie.prototype.toArray = function() {
  var array = [];
  for (var i in this.root.children) {
    this.root.children[i].toArray(array);
  }
  return array;
};

/**
 * Given a prefix string, find any possible matches in the trie.
 * A use case for this is an autocomplete field where a user
 * enters in a partial string and we need to show any results
 * that prefix that string.
 *
 * @param  {String} prefix
 * @return {Array}
 */
Trie.prototype.match = function(prefix) {
  var node = this.root;
  var pointer = 0;
  while (pointer < prefix.length) {
    var letter = prefix[pointer];
    // If the letter isn't found,
    if (!node.children[letter]) return [];
    node = node.children[letter];
    pointer++;
  }
  return node.matches;
};

/**
 * Given a word, return true if the trie contains it.
 */
Trie.prototype.search = function(word) {
  var node = this.root;
  var pointer = 0;
  while (pointer < word.length) {
    var letter = word[pointer];
    if (!node.children[letter]) {
      return false;
    }
    node = node.children[letter];
    pointer++;
  }

  return node.complete;
}

module.exports = Trie;
