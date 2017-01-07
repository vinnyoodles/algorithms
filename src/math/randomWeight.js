function randomWeight(array, weights) {
  var total = weights.reduce((a, b) => a + b, 0);
  var standard = 1 / total;
  var start = 0;
  var ranges = array.map((current, index) => {
    var weight = weights[index];
    var range = [start, (standard * weight) + start];
    start = (standard * weight) + start;
    return range;
  });

  var random = Math.random();
  for (var i in ranges) {
    var range = ranges[i];
    if (range[0] <= random && range[1] >= random) return array[i];
  }
  return -1;
}

module.exports = randomWeight;
