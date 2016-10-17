var mergesort = require('../../src/sort/mergesort');

describe('mergesort', () => {
  it('should sort an unsorted array', () => {
    var array = [1, 9, 2, 8, 3, 7, 4, 6, 5];
    expect(mergesort(array)).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9]);
  });

  it('should work for an empty array', () => {
    expect(mergesort([])).toEqual([]);
  })

  it('should work for an array of a single value', () => {
    expect(mergesort([1])).toEqual([1]);
  })

  it('should work for an already sorted array', () => {
    expect(mergesort([1, 2, 3])).toEqual([1, 2, 3]);
  })
});
