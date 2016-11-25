/**
 * Given an array, find the longest subarray whose sum is less than or equal to k.
 * A subarray is defined to be a contiguous range of values that is within the bounds of the given array.
 *
 * @param  {Array} array
 * @param  {Int} k
 * @return {Int} the length of the greatest subarray.
 */
function greatestSubarray(arr, k) {
  if (!arr.length) {
    return 0;
  } else if (arr.length === 1 && arr[0] <= k) {
    return 1;
  } else if (arr.length === 1 && arr[0] > k) {
    return 0;
  }
  // Keep a pointer that stores the start index of the current subarray.
  var pointer = 0;
  // The current sum of the subarray.
  var count;
  // Keep the highscore out of all the subarrays.
  var greatestLength;
  arr.forEach(function(value, index) {
    // Initialize.
    if (!count) {
      count = value;
    // If the sum and the current value are still less than k, than add the value and continue.
    } else if (value + count <= k) {
      count += value;
    // If the current sum is greater than k, then move the pointer over.
    // Check if the current length is higher than the highscore, if so reset it.
    } else {
      // Make sure the score exists.
      greatestLength = greatestLength || 0;
      var newLength = index - pointer;
      if (newLength > greatestLength && count <= k) {
        greatestLength = newLength;
      }
      count -= arr[pointer];
      count += value;
      pointer ++;
    }
  });

  // If the greatestLength is 0, then the sum was always greater than k.
  if (greatestLength === 0) return 0;

  // If its undefined, then the sum was never greater than k.
  else if (greatestLength === undefined) return arr.length;
  return greatestLength > arr.length - pointer ? greatestLength : arr.length - pointer;
}

module.exports = greatestSubarray;
