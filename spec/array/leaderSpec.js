var leader = require('../../javascript/array/leader');

describe('leader', () => {
  it('should return all leaders in the array', () => {
    expect(leader([98, 23, 54, 12, 20, 7, 27])).toEqual([27, 54, 98]);
    expect(leader([1, 2, 3, 4, 5])).toEqual([5]);
    expect(leader([5, 4, 3, 2, 1])).toEqual([1, 2, 3, 4, 5]);
    expect(leader([5])).toEqual([5]);

    // This is me spamming a bunch of number keys
    expect(leader([243,14,124,124,124,12,412,412,4312,312,3,125,124,2543,51245,224531,425,12352,314,235564214,5651,3124,12,412,4123,5431435423,5,23453,54,12435,142,5423,56124,526,4235,234,235,235,234,243,565241345436,5124,526,5134,1235,245,2341,325,3])).toEqual([3, 325, 2341, 5134, 565241345436]);
  });

  it('should work for empty arrays', () => {
    expect(leader([])).toEqual([]);
  });

});
