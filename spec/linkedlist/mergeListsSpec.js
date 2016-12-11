var ListNode = require('../../src/linkedlist/ListNode');
var mergeLists = require('../../src/linkedlist/mergeLists');

describe('mergeLists', () => {
  it('should merge lists', () => {
    var a = new ListNode(1);
    a.append([3, 5, 7]);
    var b = new ListNode(2);
    b.append([4, 6, 8]);
    expect(mergeLists(a, b).toArray()).toEqual([1, 2, 3, 4, 5, 6, 7, 8]);
  });

  it('should merge uneven lists', () => {
    var a = new ListNode(1);
    var b = new ListNode(2);
    b.append([4, 6, 8]);
    expect(mergeLists(a, b).toArray()).toEqual([1, 2, 4, 6, 8]);
  });

  it('should merge lists of 1 each', () => {
    var a = new ListNode(1);
    var b = new ListNode(2);
    expect(mergeLists(a, b).toArray()).toEqual([1, 2]);
  });

  it('should merge list with null', () => {
    var a = new ListNode(1);
    expect(mergeLists(a, null).toArray()).toEqual([1]);
  });

  it('should merge null with list', () => {
    var a = new ListNode(1);
    expect(mergeLists(null, a).toArray()).toEqual([1]);
  });

  it('should merge big lists', () => {
    var a = new ListNode(1);
    a.append([3, 5, 7, 9, 11, 13, 51, 65, 124, 144, 1324, 12315, 2352525, 2312424211214, 9999999]);
    var b = new ListNode(2);
    b.append([4, 6, 8]);
    expect(mergeLists(a, b).toArray()).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 51, 65, 124, 144, 1324, 12315, 2352525, 2312424211214, 9999999]);
  });

  it('should merge negatives too', () => {
    var a = new ListNode(1);
    a.append([3, 5, 7, 9, 11, 13, 51, 65, 124, 144, 1324, 12315, 2352525, 2312424211214, 9999999]);
    var b = new ListNode(-2000);
    b.append([-1000, -900, -800, -500, -10, 0, 2]);
    expect(mergeLists(a, b).toArray()).toEqual([-2000, -1000, -900, -800, -500, -10, 0, 1, 2, 3, 5, 7, 9, 11, 13, 51, 65, 124, 144, 1324, 12315, 2352525, 2312424211214, 9999999]);
  });

  it('should merge two big lists', () => {
    var a = new ListNode(1);
    a.append([10, 200, 400, 600, 1000, 9000, 9999, 10000]);
    var b = new ListNode(-10);
    b.append([11, 201, 300, 350, 400, 401, 402, 403, 500, 501, 502, 503, 504, 600, 6000, 7000, 99999]);
    expect(mergeLists(a, b).toArray()).toEqual([-10, 1, 10, 11, 200, 201, 300, 350, 400, 400, 401, 402, 403, 500, 501, 502, 503, 504, 600, 600, 1000, 6000, 7000, 9000, 9999, 10000, 99999]);
  });

  it('should merge duplicates', () => {
    var a = new ListNode(1);
    a.append([2, 3, 4, 5, 6, 7]);
    var b = new ListNode(1);
    b.append([2, 3, 4, 5, 6, 7]);
    expect(mergeLists(a, b).toArray()).toEqual([1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7]);
  });
});
