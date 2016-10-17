/**
 * A divide and conquer implementation for sorting an array.
 * Divide the original array into subarrays of length 2.
 * Conquer by sorting each subarray.
 * Merge all subarray back into a single, sorted array.
 * @param  {[type]} array [description]
 * @return {[type]}       [description]
 */
function mergesort(array) {
  // Base case where the array contains, at most, a single element.
  if (array.length < 2) return array;

  // Divide the arrays into subarrays.
  var midpoint = Math.round(array.length / 2);
  var left = array.slice(0, midpoint);
  var right = array.slice(midpoint, array.length);

  // Conquery each individual subarray.
  left = mergesort(left);
  right = mergesort(right);

  // Merge the sorted arrays back together.
  return merge(left, right);
}

/**
 * Merge two unsorted arrays into a single sorted array.
 * @param  {Array} left
 * @param  {Array} right
 * @return {Array}
 */
function merge(left, right) {
  var sorted = [];
  // Iterate both arrays together and push the lower value into the new array.
  while (left.length && right.length) {
    var leftValue = left[0];
    var rightValue = right[0];
    if (leftValue > rightValue) {
      sorted.push(right.shift());
    } else {
      sorted.push(left.shift());
    }
  }

  // If the two arrays are unbalanced, then push whatever is left in the longer array.
  while (left.length) {
    sorted.push(left.shift());
  }

  while (right.length) {
    sorted.push(right.shift());
  }

  return sorted;
}

module.exports = mergesort;
