var knapsack = require('../../src/recursion/knapsack');

describe('knapsack', () => {
  it('should return an array of indexes', () => {
    expect(knapsack([2, 2, 4, 5], [3, 7, 2, 9], 10)).toEqual([0, 1, 3]);
  });

  it('should work for a lot of items', () => {
    expect(knapsack([2, 4, 1, 4, 5, 12, 3, 5, 3, 12, 31, 51],
                    [1, 3, 12, 31, 4, 3, 1, 4, 9, 7, 4, 19], 20)).toEqual([0, 2, 3, 4, 7, 8]);
  });
});
