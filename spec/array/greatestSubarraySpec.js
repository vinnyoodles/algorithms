var greatestSubarray = require('../../src/array/greatestSubarray');

describe('greatestSubarray', () => {
  it('should return the greatest subarray whose sum is less than k', () => {
    var array = [1, 3, 5, 7, 9, 11, 13, 15];
    var k = 15;
    expect(greatestSubarray(array, k)).toEqual(3);
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

  it('should return the greatest subarray near the end', () => {
    var array = [1, 1, 100, 1, 1, 5];
    var k = 10;
    expect(greatestSubarray(array, k)).toEqual(3);
  });

  it('should return the greatest subarray near the beginning', () => {
    var array = [1, 2, 1, 2, 3, 4, 30, 1, 5, 2, 4, 20];
    var k = 10;
    expect(greatestSubarray(array, k)).toEqual(5);
  });

  it('should return the greatest subarray near the middle', () => {
    var array = [20, 25, 1, 2, 3, 2, 3, 1, 2, 3, 50, 100];
    var k = 15;
    expect(greatestSubarray(array, k)).toEqual(7);
  });

  it('should test all cases', () => {
    expect(greatestSubarray([], 1)).toEqual(0);
    expect(greatestSubarray([5], 1)).toEqual(0);
    expect(greatestSubarray([5], 5)).toEqual(1);
  });
});
