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
  var a = x.length;
  var b = y.length;
  var grid = [];

  // Create the 2D array of length x times length y.
  // The 2D array will store the length of the current subsequence for that specific subproblem.
  for (var i = 0; i < a + 1; i ++) {
    grid.push(new Array(b + 1));
  }

  // Break the problem into subproblems where we compare all of string Y with a subset of X.
  // Each iteration, we know more about the longest subsequence for that subset of X.
  for (var i = 0; i <= a; i ++) {
    for (var j = 0; j <= b; j ++ ) {
      // The first row and the first column are used to compare the string with the null set.
      if(i == 0 || j == 0){
        grid[i][j] = 0;

      // If the characters are equal, then include it in the current subsequence.
      } else if(x.charAt(i - 1) === y.charAt(j - 1)) {

        // Update the grid by incrementing the length of the subsequence.
        grid[i][j] = grid[i - 1][j - 1] + 1;

      // If the characters do not match, then assign the length of the subsequence of the subproblem before it or the length of the subsequence excluding this character.
      } else {
        grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
      }
    }
  }

  return grid[a][b];
};

module.exports = longestSubsequence;
