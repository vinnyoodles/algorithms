var gridTraversal = require('../../src/graph/gridTraversal');

describe('gridTraversal', () => {
  beforeEach(() => {
    this.grid = [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ];
  });

  it('should return the traversal path', () => {
    expect(gridTraversal(this.grid, 0, 0)).toEqual([1, 4, 7, 8, 9, 6, 5, 2, 3]);
  });

  it('should skip neighbors with values less than 0', () => {
    this.grid[1][0] = 0;
    expect(gridTraversal(this.grid, 0, 0)).toEqual([1, 2, 5, 8, 9, 6, 3]);
  });

  it('should return the path from any location', () => {
    expect(gridTraversal(this.grid, 1, 1)).toEqual([5, 8, 9, 6, 3, 2, 1, 4, 7]);
  });
});
