/**
 * Find the longest subsequence that appear in both given strings and return the length of the subsequence.
 * A subsequence is a subset of a string that may or may not be continuous but is in the same order.
 *
 * Ex. abc is a subsequence of abcdef
 *     abc is a subsequence of akbdec
 *     abc is NOT a subsequence of acb or adcfb
 *
 * @param  {String} x
 * @param  {Sting} y
 * @return {Int}
 */
function longestSubsequence(x, y) {
  if (x.length === 0 || y.length === 0) return 0;
  var longer = x.length > y.length ? x : y;
  var shorter = x.length > y.length ? y : x;
  var count = 0;
  // Keep the index for the current value in the shorter array.
  var pointer = 0;
  var matched = 0;
  for (var i = 0; i < longer.length; i ++) {
    // Reached the end.
    if (pointer >= shorter.length) {
      i = longer.length;
    } else if (longer[i] === shorter[pointer]) {
      pointer ++;
      count ++;
      matched = i;
    // If the end of the longer string has been reached, but there is still more in the shorter string.
    // Reset the longer string to the last matched index, and move the shorter pointer.
    } else if (i === longer.length - 1 && pointer < shorter.length) {
      i = matched;
      pointer ++;
    }
  }
  return count;
}

module.exports = longestSubsequence;
