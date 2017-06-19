var largestRegion = require('../../javascript/grid/largestRegion');

describe('largestRegion', () => {
  it('should find the largest region', () => {
    expect(largestRegion([
      [1,0,0,0,0,0,0],
      [1,0,0,0,1,0,0],
      [1,0,0,1,1,1,1],
      [0,1,0,1,0,1,1],
      [0,0,1,1,1,1,1]
    ])).toEqual(17);

    expect(largestRegion([
      [0,1,1,1,1,0,0],
      [0,0,1,1,1,1,0],
      [0,1,1,0,0,1,0],
      [0,1,1,0,0,0,0],
      [0,1,1,0,0,1,0],
      [0,1,1,1,1,0,0]
    ])).toEqual(20);

    expect(largestRegion([
      [1,1,1,1,1,011],
      [1,0,1,1,1,1,1],
      [1,1,1,0,0,1,1],
      [1,1,1,0,0,0,1],
      [1,1,1,0,0,1,1],
      [1,1,1,1,1,1,1]
    ])).toEqual(33);
  });

  it('should count diagonals', () => {
    expect(largestRegion([
      [1,0,0,0,0,0,0],
      [0,1,0,0,1,0,0],
      [0,0,1,0,0,0,1],
      [0,0,0,1,0,0,1],
      [0,0,0,0,1,0,0]
    ])).toEqual(5);

    expect(largestRegion([
      [0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0]
    ])).toEqual(0);
  });
});
