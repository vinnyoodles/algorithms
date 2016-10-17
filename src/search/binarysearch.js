function binarysearch(array, value) {
  var left = 0;
  var right = array.length - 1;
  while (left <= right) {
    var midpoint = Math.floor((right + left) / 2);
    if (array[midpoint] === value) {
      return midpoint;
    } else if (array[midpoint] < value) {
      left = midpoint + 1;
    } else if (array[midpoint] > value) {
      right = midpoint - 1;
    }
  }
  return -1;
}

module.exports = binarysearch;
