var ListNode = require('../../src/linkedlist/ListNode');
var sumLists = require('../../src/linkedlist/sumLists');

describe('sumLists', () => {
  it('should sum up two linked lists', () => {
    var a = new ListNode(1);
    var b = new ListNode(4);
    a.append([2, 3]);
    b.append([5, 6]);

    var c = sumLists(a, b);
    expect(c.toArray()).toEqual([5, 7, 9]);
  });

  it('should sum up two uneven linked lists', () => {
    var a = new ListNode(1);
    var b = new ListNode(4);
    a.append([2, 3, 5]);
    b.append([5, 6]);

    var c = sumLists(a, b);
    expect(c.toArray()).toEqual([5, 7, 9, 5]);
  });

  it('should take into account carries', () => {
    var a = new ListNode(9);
    var b = new ListNode(9);
    a.append([9, 9, 9]);
    b.append([9, 9]);

    var c = sumLists(a, b);
    expect(c.toArray()).toEqual([8, 9, 9, 0, 1]);
  });
});
