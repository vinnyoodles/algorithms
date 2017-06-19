// Find all permutations of an array of arrays.
function permutations(arrays) {
  return recursivePermutations(arrays, 0);
}

function recursivePermutations(arrays, index) {
  var temp;
  // Bottoms up approach.
  if (index < arrays.length - 1) {
    // Get the initial array from the end.
    temp = recursivePermutations(arrays, index + 1);
  } else {
    // Start with an array of a single empty array.
    temp = [ [ ] ] ;
  }

  var result = []
  for (var i = 0; i < temp.length; i ++) {
    var current = temp[i];

    for (var j = 0; j < arrays[index].length; j ++) {
      // Update the current array and add to result.
      current.push(arrays[index][j]);
      result.push(current.slice());

      // Backtrack by removing the value.
      current.pop()
    }
  }

  return result;
}

module.exports = permutations;
