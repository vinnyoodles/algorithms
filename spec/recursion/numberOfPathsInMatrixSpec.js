var numberOfPathsInMatrix = require('../../javascript/recursion/numberOfPathsInMatrix');

describe('numberOfPathsInMatrix', () => {
  it('should return the number of paths in the matrix', () => {
    expect(numberOfPathsInMatrix([
      [0, 1, 1],
      [0, 0, 1],
      [1, 0, 0]
    ])).toEqual(1);
  });

  it('should return the number of paths in the matrix', () => {
    expect(numberOfPathsInMatrix([
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0]
    ])).toEqual(6);
  });

  it('should return the number of paths in the matrix', () => {
    expect(numberOfPathsInMatrix([
      [0, 1, 1],
      [1, 1, 1],
      [1, 1, 0]
    ])).toEqual(0);
  });
});
