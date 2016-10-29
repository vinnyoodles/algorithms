var greatestSubarray = require('../../src/array/greatestSubarray');

describe('greatestSubarray', () => {
  it('should return the greatest subarray whose sum is less than k', () => {
    var array = [1, 3, 5, 7, 9, 11, 13, 15];
    var k = 15;
    expect(greatestSubarray(array, k)).toEqual(4);
  });

  it('should work if the whole array is the greatest subarray', () => {
    var array = [74,659,931,273,545,879,924];
    var k = 22337;
    expect(greatestSubarray(array, k)).toEqual(7);
  });

  it('should work if no subaray exists', () => {
    var array = [74,659,931,273,545,879,924];
    var k = 5;
    expect(greatestSubarray(array, k)).toEqual(0);
  });
});
