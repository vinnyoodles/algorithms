/**
 * Find the minimum number of operations to equalize all values in the array.
 * An operation is incrementing a value by 1.
 *
 * Ex. [1, 2, 3] requires 3 operations to make [3, 3, 3].
 *
 * @param  {Array} array
 * @return {Int}
 */
function minAdditions(array) {
  var min = Number.MAX_SAFE_INTEGER;
  var sum = 0;

  for (var i in array) {
    sum += array[i];
    min = Math.min(min, array[i]);
  }

  return sum - (min * array.length);
}

module.exports = minAdditions;
