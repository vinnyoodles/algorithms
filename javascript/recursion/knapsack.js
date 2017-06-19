/**
 * Given a set of items, each with weight and benefit, determine the items
 * to include in the knapsack so that the total weight is less than or
 * equal to a given weight limit and the total benefit is maximized.
 *
 * @param  {Array} weights
 * @param  {Array} benefits
 * @param  {Int} maxWeight
 * @return {Array} of indexes of the items
 */
function knapsack(weights, benefits, maxWeight) {
  if (maxWeight < 1 || !weights.length || benefits.length !== weights.length) return [];
  return knapsackRecurse(weights, benefits, maxWeight, [], 0, 0, 0);
}

function knapsackRecurse(weights, benefits, maxWeight, indexes, currentIndex, currentWeight, currentBenefit) {
  if (currentWeight >= maxWeight || currentIndex >= weights.length) return indexes;

  var weight = weights[currentIndex];
  var benefit = benefits[currentIndex];

  if (weight > maxWeight || weight + currentWeight > maxWeight) return knapsackRecurse(weights, benefits, maxWeight, indexes, currentIndex + 1, currentWeight, currentBenefit);

  var withSack = knapsackRecurse(weights, benefits, maxWeight, indexes.concat(currentIndex), currentIndex + 1, currentWeight + weight, currentBenefit + benefit);
  var without = knapsackRecurse(weights, benefits, maxWeight, indexes, currentIndex + 1, currentWeight, currentBenefit);

  var a = sumBenefit(benefits, withSack);
  var b = sumBenefit(benefits, without);
  return (a > b) ? withSack : without;
}

function sumBenefit(benefits, indexes) {
  var sum = 0;
  indexes = indexes.slice();
  for (var i in benefits) {
    if (!indexes.length) return sum;
    else if (indexes[0] == i) {
      sum += benefits[i];
      indexes.shift();
    }
  }
  return sum;
}

module.exports = knapsack;
