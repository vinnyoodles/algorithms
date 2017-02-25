var flip = require('../../src/string/flipParenthesis');


describe('flip parenthesis', () => {
  it('should work', () => {
    expect(flip('(((())))')).toEqual(0);
    expect(flip('(()(((')).toEqual(2);
    expect(flip('))((')).toEqual(2);
    expect(flip('))(())((((')).toEqual(3);
    expect(flip('(())((')).toEqual(1);
    expect(flip(')))(()')).toEqual(2);
  });
});
