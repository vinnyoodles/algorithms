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
  for (var i = 0; i < a + 1; i ++) {
    grid.push(new Array(b + 1));
  }

  for (var i = 0; i <= a; i ++) {
    for (var j = 0; j <= b; j ++ ) {
      if(i == 0 || j == 0){
        grid[i][j] = 0;
      } else if(x.charAt(i - 1) === y.charAt(j - 1)) {
        grid[i][j] = grid[i-1][j-1] + 1;
      } else {
        grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
      }
    }
  }
  return grid[a][b];
};

module.exports = longestSubsequence;
