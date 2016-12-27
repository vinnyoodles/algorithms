function staircase(n) {
  return staircaseMemoize(n, {});
}

function staircaseRecurse(n) {
  if (n < 0) {
    return 0;
  } else if (n === 0) {
    return 1;
  } else {
    return staircaseRecurse(n - 1) + staircaseRecurse(n - 2) + staircaseRecurse(n - 3);
  }
}

function staircaseMemoize(n, table) {
  if (table[n]) {
    return table[n];
  } else if (n < 0) {
    return 0;
  } else if (n === 0) {
    return 1;
  } else {
    // Cache the results in the same table.
    var oneStep = table[n - 1] = staircaseMemoize(n - 1, table);
    var twoSteps = table[n - 2] = staircaseMemoize(n - 2, table);
    var threeSteps = table[n - 3] = staircaseMemoize(n - 3, table);

    return oneStep + twoSteps + threeSteps;
  }
}

module.exports = staircase;
