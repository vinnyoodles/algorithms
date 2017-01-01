function kmp(search, target) {
  var failureTable = createTable(target);

  var targetPointer = 0; // Current char in target string.
  var searchPointer = 0; // Current char in search string.

  // While there is more to search with, keep searching.
  while (searchPointer < search.length) {
    // Found current char in targetPointer in search string.
    if (search[searchPointer] == target[targetPointer]) {
      targetPointer++;
      // Found all characters
      if (targetPointer === target.length) {
         // Return starting index of found target inside searched string.
        return searchPointer - targetPointer + 1;
      }
      // Move forward if not found target string.
      searchPointer++;
    } else if (targetPointer > 0) {
      // Use failureTable to use pointer pointed at nearest location of usable string prefix.
      targetPointer = failureTable[targetPointer];
    } else {
      // targetPointer is pointing at state 0, so restart search with current searchPointer index.
      searchPointer++;
    }
  }
  // Not found.
  return -1;
}

/**
* Returns an int[] that points to last valid string prefix, given target string
*/
function createTable(target) {
  var table = new Array(target.length + 1);
  // State 0 and 1 are guarenteed to be the prior.
  table[0] = -1;
  table[1] = 0;

  // Use the sliding window method starting at the last failure and the current state.
  var left = 0;
  var right = 2;

  // The right pointer must never move right unless assigned a valid pointer.
  while (right < table.length) {
    // When both chars before left and right are equal, link both and move both forward
    if (target[right - 1] === target[left]) {
      left++;
      table[right] = left;
      right++;
      // If left isn't at the very beginning, then send left backward by following the already set pointer to where it is pointing to.
    } else if (left > 0) {
      left = table[left];
    } else { // Left has fallen all the way back to the beginning
      table[right] = left;
      right++;
    }
  }
  return table;
}

module.exports = {
  createTable,
  kmp
};
