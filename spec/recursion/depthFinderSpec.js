var depthFinder = require('../../javascript/recursion/depthFinder');

describe('depthFinder', () => {
  it('should return the object with each value\'s path', () => {
    expect(depthFinder([1, 2, 3])).toEqual({
      1: [0],
      2: [1],
      3: [2]
    });
  });

  it('should return the object with each value\'s path', () => {
    expect(depthFinder([1, 2, [3]])).toEqual({
      1: [0],
      2: [1],
      3: [2, 0]
    });
  });

  it('should return the object with each value\'s path', () => {
    expect(depthFinder([1, 2, [3, [4]]])).toEqual({
      1: [0],
      2: [1],
      3: [2, 0],
      4: [2, 1, 0]
    });
  });

  it('should return the object with each value\'s path', () => {
    expect(depthFinder([1, 2, [3, [4, [[5]]]]])).toEqual({
      1: [0],
      2: [1],
      3: [2, 0],
      4: [2, 1, 0],
      5: [2, 1, 1, 0, 0]
    });
  });

  it('should return the object with each value\'s path', () => {
    expect(depthFinder([[[1]]])).toEqual({
      1: [0, 0, 0]
    });
  });

  it('should return the object with each value\'s path', () => {
    expect(depthFinder([[[1], [[[2]]]]])).toEqual({
      1: [0, 0, 0],
      2: [0, 1, 0, 0, 0]
    });
  });
});
