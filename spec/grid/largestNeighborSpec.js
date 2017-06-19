var largestNeighbor = require('../../javascript/grid/largestNeighbor');

describe('largestNeighbor', () => {
  beforeAll(() => {
    this.grid = [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ];
  });

  it('should return the largest neighbor', () => {
    expect(largestNeighbor(this.grid, 1, 0)).toEqual({x: 1, y: 1});
  });

  it('should skip out of bounds neighbors', () => {
    expect(largestNeighbor(this.grid, 0, 0)).toEqual({x: 0, y: 1});
    expect(largestNeighbor(this.grid, 2, 2)).toEqual({x: 1, y: 2});
  });

  it('should skip diagonal neighbors', () => {
    expect(largestNeighbor(this.grid, 1, 1)).toEqual({x: 1, y: 2});
  });
});
