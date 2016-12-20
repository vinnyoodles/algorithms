var knapsack = require('../../src/recursion/knapsack');

describe('knapsack', () => {
  it('should return an array of indexes', () => {
    var items = [{
      weight: 2,
      benefit: 3
    }, {
      weight: 2,
      benefit: 7
    }, {
      weight: 4,
      benefit: 2
    }, {
      weight: 5,
      benefit: 9
    }];
    expect(knapsack(items, 10)).toEqual([0, 1, 3]);
  });

  it('should work for a lot of items', () => {
    var items = [{
      weight: 2,
      benefit: 3
    }, {
      weight: 4,
      benefit: 45
    }, {
      weight: 1,
      benefit: 0
    }, {
      weight: 4,
      benefit: 13
    }, {
      weight: 5,
      benefit: 2
    }, {
      weight: 51,
      benefit: 1
    }, {
      weight: 13,
      benefit: 7
    }, {
      weight: 4,
      benefit: 2
    }, {
      weight: 2,
      benefit: 1
    }, {
      weight: 1,
      benefit: 2
    }, {
      weight: 2,
      benefit: 7
    }, {
      weight: 4,
      benefit: 9
    }, {
      weight: 5,
      benefit: 9
    }];
    expect(knapsack(items, 20)).toEqual([0, 1, 3]);
  });
});
