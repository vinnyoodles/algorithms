/**
 * Given a two dimensional array with values of 0s or 1s (where 1 represents a blocked wall).
 * Return the total number of paths to traverse from the origin (0, 0) to the bottom right corner (x - 1, y - 1).
 * The only direction to move is either to the right or down.
 *
 * @param {Array<Array>} two dimensional array of 0s and 1s.
 * @return {Integer} number of paths.
 */

function numberOfPathsInMatrix(array) {
  if (!array.length || !array[0].length) return 0;
  return findNumberOfPaths(array, 0, 0, 0);
}

function findNumberOfPaths(array, n, m, paths) { // jshint ignore:line
  // Check if the coordinates are out of bounds.
  if (m >= array.length || n >= array[0].length) return paths;
  // Check if the coordinates point to a wall.
  else if (array[m][n] === 1) return paths;
  // Check if the coordinates point to the goal.
  else if (m === array.length - 1 && n === array[0].length - 1) return paths + 1;
  return findNumberOfPaths(array, n + 1, m, paths) + findNumberOfPaths(array, n, m + 1, paths);
}

module.exports = numberOfPathsInMatrix;
