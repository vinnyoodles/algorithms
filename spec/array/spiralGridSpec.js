var spiralGrid = require('../../src/array/spiralGrid');

describe('spiralGrid', () => {
  it('should return an array', () => {
    expect(spiralGrid([[1, 2, 3], [4, 5, 6], [7, 8, 9]])).toEqual([1, 2, 3, 6, 9, 8, 7, 4, 5]);
  });

  it('should work for invalid inputs', () => {
    expect(spiralGrid([])).toEqual([]);
    expect(spiralGrid()).toEqual([]);
    expect(spiralGrid(undefined)).toEqual([]);
    expect(spiralGrid([[]])).toEqual([]);
  });

  it('should work for rectangular grids', () => {
    expect(spiralGrid([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]])).toEqual([1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]);
    expect(spiralGrid([[1, 2],
      [3, 9],
      [9, 0],
      [8, 1],
      [2, 2],
      [1, 7],
      [3, 4],
      [8, 4],
      [7, 6],
      [7, 2],
      [4, 6],
      [2, 1],
      [5, 6],
      [3, 4],
      [5, 6],
      [7, 8]])).toEqual([1,2,9,0,1,2,7,4,4,6,2,6,1,6,4,6,8,7,5,3,5,2,4,7,7,8,3,1,2,8,9,3]);
  });
});
