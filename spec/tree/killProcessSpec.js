var killProcess = require('../../src/tree/killProcess');

describe('killProcess', () => {
  it('should return a list of all the connected pids', () => {
    expect(killProcess([1, 3, 10, 5], [3, 0, 5, 3], 5)).toEqual([5, 10]);
    expect(killProcess([1, 3, 10, 5], [10, 0, 5, 3], 5)).toEqual([5, 10, 1]);

    expect(killProcess([1, 2, 3], [0, 1, 1], 1)).toEqual([1, 2, 3]);
  });
});
