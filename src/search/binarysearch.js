/**
 * A binary search runs in o(logn) by decreasing the search boundaries by half for each iteration.
 * @param  {Array} array The array to search in.
 * @param  {Int} value   The value to search for.
 * @return {Int}         The index of the found value or -1 if not found.
 */
function binarysearch(array, value) {
  // Create the initial boundaries containing the entire array..
  var left = 0;
  var right = array.length - 1;
  // Iterate through the array until the boundaries collide.
  while (left <= right) {
    // Calculate the midpoint.
    var midpoint = Math.floor((right + left) / 2);
    if (array[midpoint] === value) {
      return midpoint;
    // Upper half.
    } else if (array[midpoint] < value) {
      left = midpoint + 1;
    // Lower half.
    } else if (array[midpoint] > value) {
      right = midpoint - 1;
    }
  }
  // A collision has occured but the value was not found.
  return -1;
}

module.exports = binarysearch;
