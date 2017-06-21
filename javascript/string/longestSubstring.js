/**
 * Given a string, find the length of the longest substring without repeating characters.
 * @param {string} s
 * @return {number}
 */
function lengthOfLongestSubstring(s) {
  if (!s.length) return 0;

  // Convert to char array.
  var arr = s.split('');
  var length = 0;

  // Mapping of character to its occuring index.
  var table = {};
  var i = 0;

  // Iterate through the string.
  for (var j = 0;j < arr.length; j++) {

    // If the character has already exists, then move the start pointer.
    if (table[arr[j]] !== undefined) {
      // since character, arr[j], already exists then move i.
      // if i is already past that occurence, then leave it.
      // if i is behind the occurence, then move it in front of it.
      i = Math.max(i, table[arr[j]] + 1);
    }
    table[arr[j]] = j;
    length = Math.max(length, j - i + 1);
  }

  return length;
}

module.exports = lengthOfLongestSubstring;