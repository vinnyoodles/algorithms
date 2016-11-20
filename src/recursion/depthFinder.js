/**
 * Given an arbitrary array, return a table with each value in the array pointing to its path using its indexes.
 * An arbitrary array is defined as an array with values as either integers or a nested arbitrary array.
 *
 * Examples:
 * [1, 2, 3] => { 1: [0], 2: [1], 3: [2] }
 * [1, 2, [3]] => { 1: [0], 2: [1], 3: [2, 0] }
 * [1, 2, [3, [4]]] => { 1: [0], 2: [1], 3: [2, 0], 4: [2, 1, 0] }
 *
 * Explanations:
 * The first test case is a simple integer array so the return object is just the value pointing to its index.
 * The second case has a nested array of [3] for the 3rd value so its path is equal to [2, 0] since its the 2nd index in the first array and the 0th index in the nested array.
 * The third case is the same as above where the value 4 is the 2nd index in the first array, 1st index in the nested array, and the 0th index in the nested nested array.
 *
 * @param  {Array} arr
 * @return {Object}
 */
function depthFinder(arr) {
  return depthFinderRecursive(arr, {} /* Empty table to start */, [] /* Empty path to start */);
}

function depthFinderRecursive(arr, table, path) { // jshint ignore:line
  for (var i in arr) {
    // Add the current index into the path.
    path.push(Number(i));

    if (typeof arr[i] === 'number') {
      // Set the value as a clone of the path since it will be mutating.
      table[arr[i]] = path.slice();
    } else { // Nested array
      depthFinderRecursive(arr[i], table, path);
    }

    // Take the current index out of the path.
    path.pop();
  }

  return table;
}

module.exports = depthFinder;
