var pascalsTriangle = require('../../src/recusrion/pascalsTriangle');

describe('pascalsTriangle', () => {
  it('should return pascal\'s triangle', () => {
    expect(pascalsTriangle(1).toEqual(['1']));
  });

  it('should return pascal\'s triangle with 3 levels', () => {
    expect(pascalsTriangle(3).toEqual(['1', '1 1', '1 2 1']));
  });

  it('should return pascal\'s triangle with 5 levels', () => {
    expect(pascalsTriangle(4).toEqual(['1', '1 1', '1 2 1', '1 3 3 1', '1 4 6 4 1']));
  });
});
