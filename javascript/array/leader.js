/**
 * Given an array of integers, print the leaders in the array.
 * A leader is an element which is larger than all the elements in the array to its right.
 *
 * @param  {Array} array
 * @return {Array}
 */
function leader(array) {
  if (!array.length) return array;
  
  var currentLeader = array[array.length - 1];
  var leaders = [currentLeader];
  for (var i = array.length - 2; i >= 0; i--) {
    if (array[i] > currentLeader) {
      leaders.push(array[i]);
      currentLeader = array[i];
    }
  }

  return leaders;
}

module.exports = leader;
