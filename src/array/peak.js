/**
 * Given an array, find a peak element in the array.
 * Peak element is the element which is greater than or equal to its neighbors.
 *
 * @param  {Array} array
 * @return {Int}
 */
function peak(array) {
  return findPeak(array, 0, array.length - 1);
}

function findPeak(array, start, end) {
  var middle = parseInt((start + end) / 2);

  if (start > end) return null;
  else if (isPeak(array, middle)) return array[middle];
  else if (array[middle] < array[middle - 1]) return findPeak(array, start, middle - 1);

  return findPeak(array, middle + 1, end);
}

function isPeak(array, index) {
  if (!array.length) return false;

  var right = array[index] > array[index + 1];
  var left = array[index] > array[index - 1];

  if (index === 0) return right;
  else if (index === array.length - 1) return left;

  return left && right;
}

module.exports = peak;
