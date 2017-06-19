/**
 * Find the neighbor of the current node with the greatest value.
 * If no neighbor with a value greater than 0 exists, then return an empty object.
 *
 * A node is defined with a (x, y) coordinate to find its value in the grid.
 * var node = {
 *   x: x,
 *   y: y
 * }
 *
 * @param {2D Array} grid
 * @param {Integer} x
 * @param {Integer} y
 */
function largestNeighbor(grid, x, y) {
  var value = Number.MIN_VALUE;
  var target = {};
  // Iterate through each adjacent grid.
  for (var n = x - 1; n <= x + 1; n++) {
    for (var m = y - 1; m <= y + 1; m++) {
      // Check if the coordinates are within the grid.
      if (n < 0 || m < 0 || n >= grid[0].length || m >= grid.length) continue;
      // Check if the coordinate is a diagonal.
      else if ((n === x || m !== y) && (n !== x || m === y)) continue;

      // Update the selected grid if it is greater.
      if (grid[m][n] > 0 && grid[m][n] > value) {
        value = grid[m][n];
        target.x = n;
        target.y = m;
      }
    }
  }
  return target;
}

module.exports = largestNeighbor;
