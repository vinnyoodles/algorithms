var peak = require('../../javascript/array/peak');

describe('peak', () => {
  it('should find a peak element', () => {
    expect([4, 7]).toContain(peak([1, 4, 3, 6, 7, 5]));
    expect([4, 9]).toContain(peak([1, 4, 2, 3, 6, 7, 9]));
  });

  it('should work for end elements', () => {
    expect([8]).toContain(peak([1, 2, 3, 4, 5, 6, 7, 8]));
  });

  it('should work for start elements', () => {
    expect([5]).toContain(peak([5, 4, 3, 2, 1]));
  });
});
