var minAdditions = require('../../src/array/minAdditions');

describe('minAdditions', () => {
  it('should find the minimum number of operations', () => {
    expect(minAdditions([1, 2, 3])).toEqual(3);
  });

  it('should find the minimum number of operations', () => {
    expect(minAdditions([1, 2, 3, 4])).toEqual(6);
  });

  it('should find the minimum number of operations', () => {
    expect(minAdditions([1, 10, 20, 30, 40, 50])).toEqual(145);
    expect(minAdditions([50, 40, 30, 20, 10, 1])).toEqual(145);
  });

  it('should find the minimum number of operations', () => {
    expect(minAdditions([1, 2, 4, 5])).toEqual(8);
  });
});
