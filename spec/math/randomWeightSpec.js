var randomWeight = require('../../src/math/randomWeight');

describe('randomWeight', () => {
  it('should work', () => {
    expect(randomWeight([1, 2, 3], [1, 1, 2])).toBeWithinRange(1, 3);
    expect(randomWeight([1, 2, 3], [0, 0, 1])).toEqual(3);
    expect(randomWeight([1, 2, 3], [0, 1, 0])).toEqual(2);
    expect(randomWeight([1, 2, 3], [1, 0, 0])).toEqual(1);
  });
});
