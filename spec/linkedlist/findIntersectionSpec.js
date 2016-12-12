var ListNode = require('../../src/linkedlist/ListNode');
var findIntersection = require('../../src/linkedlist/findIntersection');

describe('findIntersection', () => {
  it('should find the intersecting node', () => {
    var a = new ListNode(1);
    a.append([2, 3, 4, 5, 6]);
    var third = a.next.next;
    var b = new ListNode(10);
    b.next = third;
    expect(findIntersection(a, b)).toEqual(third);
    expect(findIntersection(a, b).toArray()).toEqual([3, 4, 5, 6]);
  });

  it('should return null if it does not exist', () => {
    var a = new ListNode(1);
    a.append([2, 3, 4, 5, 6]);
    var third = a.next.next;
    var b = new ListNode(10);
    expect(findIntersection(a, b)).toEqual(null);
  });

  it('should work if b is longer', () => {
    var a = new ListNode(1);
    a.append([2, 3, 4, 5, 6]);
    var third = a.next.next;
    var b = new ListNode(10);
    b.next = third;
    expect(findIntersection(b, a)).toEqual(third);
    expect(findIntersection(b, a).toArray()).toEqual([3, 4, 5, 6]);
  });
});
