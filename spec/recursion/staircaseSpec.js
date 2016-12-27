var { staircase, _recursive } = require('../../src/recursion/staircase');

describe('staircase', () => {
  it('should return the number of steps', () => {
    expect(staircase(0)).toEqual(1);
    expect(staircase(1)).toEqual(1);
    expect(staircase(2)).toEqual(2);
    expect(staircase(3)).toEqual(4);
    expect(staircase(4)).toEqual(7);
    expect(staircase(5)).toEqual(13);
    expect(staircase(6)).toEqual(24);
    expect(staircase(7)).toEqual(44);
    expect(staircase(10)).toEqual(274);
    expect(staircase(15)).toEqual(5768);
    expect(staircase(20)).toEqual(121415);
    expect(staircase(50)).toEqual(10562230626642);
    expect(staircase(75)).toEqual(43650752323191775000);
    expect(staircase(100)).toEqual(1.803963808151009e+26);
    expect(staircase(150)).toEqual(3.081058855986474e+39);
    expect(staircase(500)).toEqual(1.3061865697021874e+132);
    expect(staircase(1000)).toEqual(2.7588428077664853e+264);
  });

  it('should return 0 for negatives', () => {
    expect(staircase(-5)).toEqual(0);
  });

  it('should also work using only recursion', () => {
    expect(staircase(0)).toEqual(_recursive(0));
    expect(staircase(1)).toEqual(_recursive(1));
    expect(staircase(2)).toEqual(_recursive(2));
    expect(staircase(3)).toEqual(_recursive(3));
    expect(staircase(4)).toEqual(_recursive(4));
    expect(staircase(5)).toEqual(_recursive(5));
    expect(staircase(6)).toEqual(_recursive(6));
    expect(staircase(7)).toEqual(_recursive(7));
    expect(staircase(10)).toEqual(_recursive(10));
    expect(staircase(15)).toEqual(_recursive(15));
  });
});
