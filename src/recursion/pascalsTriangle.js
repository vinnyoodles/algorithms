/**
 * Pascal's triangle is defined as the rth column of the nth row is n! / ( r! x (n - r)!)
 *
 * @param {Integer} n
 * @return {Array} int array where each value represents a level in the triangle.
 */
function pascalsTriangle(n) {
  // Check if the triangle is empty.
  if (!n) return [];

  return pascalsTriangleRecursive(n, [[1]]);
}

function pascalsTriangleRecursive(n, triangle) { // jshint ignore:line
  if (n <= 1) return triangle;

  // Each level starts with 1;
  var level = [1];
  var above = triangle[triangle.length - 1];

  // A direct child level has exactly one more value.
  for (var i = 1; i < above.length; i ++) {
    level[i] = above[i] + above[i - 1];
  }

  // Each level ends with 1.
  level.push(1);
  triangle.push(level);

  return pascalsTriangleRecursive(n - 1, triangle);
}

function pascalsTriangleIterative(n) { // jshint ignore:line
  // Check if n is 0.
  if (!n) return [];

  // Start with the first level already made.
  var triangle = [[1]];

  // Add each level after the first.
  for (var i = 0; i < n - 1; i++) {
    // Each level starts with 1.
    var level = [1];

    for (var j = 1; j < triangle[i].length; j++) {
      level[j] = triangle[i][j] + triangle[i][j - 1];
    }

    // Each level ends with 1.
    level.push(1);
    triangle.push(level);
  }

  return triangle;
}

module.exports = {
  pascalsTriangle,
  // For testing.
  _iterative: pascalsTriangleIterative
};
