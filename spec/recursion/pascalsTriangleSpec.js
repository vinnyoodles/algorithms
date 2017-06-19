var { pascalsTriangle, _iterative } = require('../../javascript/recursion/pascalsTriangle');

describe('pascalsTriangle', () => {
  it('should return pascal\'s triangle', () => {
    expect(pascalsTriangle(1)).toEqual([[1]]);
    expect(_iterative(1)).toEqual([[1]]);
  });

  it('should return pascal\'s triangle with 3 levels', () => {
    expect(pascalsTriangle(3)).toEqual([
      [1],
      [1, 1],
      [1, 2, 1]
    ]);

    expect(pascalsTriangle(3)).toEqual(_iterative(3));
  });

  it('should return pascal\'s triangle with 5 levels', () => {
    expect(pascalsTriangle(5)).toEqual([
      [1],
      [1, 1],
      [1, 2, 1],
      [1, 3, 3, 1],
      [1, 4, 6, 4, 1]
    ]);
    expect(pascalsTriangle(5)).toEqual(_iterative(5));
  });

  it('should return pascal\'s triangle with 10 levels', () => {
    expect(pascalsTriangle(10)).toEqual([
      [1],
      [1, 1],
      [1, 2, 1],
      [1, 3, 3, 1],
      [1, 4, 6, 4, 1],
      [1, 5, 10, 10, 5, 1],
      [1, 6, 15, 20, 15, 6, 1],
      [1, 7, 21, 35, 35, 21, 7, 1],
      [1, 8, 28, 56, 70, 56, 28, 8, 1],
      [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]
    ]);

    expect(pascalsTriangle(5)).toEqual(_iterative(5));
  });
});
