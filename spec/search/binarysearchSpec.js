var binarysearch = require('../../src/search/binarysearch');

describe('binarysearch', () => {
  it('should return the index of the value', () => {
    var array = [1, 3, 5, 7, 9, 11, 13, 15];
    var value = 13;
    expect(binarysearch(array, value)).toEqual(6);
  });

  it('should work with even number of values in the array', () => {
    var array = [1, 3, 5, 7, 9, 11, 13, 15, 17];
    var value = 13;
    expect(binarysearch(array, value)).toEqual(6);
  });

  it('should return -1 if not found', () => {
    var array = [1, 2, 3];
    var value = 4;
    expect(binarysearch(array, value)).toEqual(-1);
  });

  it('should work with an empty array', () => {
    var array = [];
    var value = 1;
    expect(binarysearch(array, value)).toEqual(-1);
  });

  it('should work with an array with a single value', () => {
    var array = [1];
    var value = 1;
    expect(binarysearch(array, value)).toEqual(0);
    expect(binarysearch(array, 2)).toEqual(-1);
  });
});
