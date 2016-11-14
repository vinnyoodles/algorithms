var largestNeighbor = require('./largestNeighbor');

/**
 * Use depth first search to traverse a 2D array.
 *
 * A node is defined with a (x, y) coordinate to find its value in the grid.
 * var node = {
 *   x: x,
 *   y: y
 * }
 *
 * A node's neighbor is confined to only the cardinal directions (north, south, east and west).
 * When traversing, prioritize neighbors with greatest value.
 * The traveral ends when the node no longer has an neighbors with a value greater than 0.
 *
 * @param {2D Array} grid where each node contains an integer.
 * @param {Integer} x start location.
 * @param {Integer} y start location.
 * @return {Array} path in order of traversal.
 */
function gridTraversal(grid, x, y) {
  if (!grid.length || !grid[0].length) return [];
  var stack = [{x: x, y: y}];
  var path = [];
  while (stack.length) {
    var node = stack.pop();
    // Mark as visited.
    path.push(grid[node.y][node.x]);
    grid[node.y][node.x] = 0;
    var neighbor = largestNeighbor(grid, node.x, node.y);
    if (neighbor.x !== undefined && neighbor.y !== undefined) stack.push(neighbor);
  }
  return path;
}

module.exports = gridTraversal;
