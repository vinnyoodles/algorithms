var ListNode = require('../../src/linkedlist/ListNode');
var cyclical = require('../../src/linkedlist/cyclical');

describe('cyclical', () => {
  it('should return false for normal lists', () => {
    var a = new ListNode([1, 2, 3, 4, 5, 6]);
    expect(cyclical(a)).toBeFalsy();
    expect(cyclical(new ListNode(1))).toBeFalsy();
  });

  it('should return true if the list has a cycle', () => {
    var a = new ListNode([1, 2, 3]);
    var lastNode = a.next.next;
    // Point the last node to the middle node;
    lastNode.next = a.next;
    expect(cyclical(a)).toBeTruthy();
  });

  it('should work', () => {
    var a = new ListNode(1);
    a.next = a;
    expect(cyclical(a)).toBeTruthy();
  });

  it('should work pt2', () => {
    var a = new ListNode([1, 2, 3, 4, 5]);
    var last = a.next.next.next.next;
    last.next = a;
    expect(cyclical(a)).toBeTruthy();
  });

  it('should work pt2', () => {
    var a = new ListNode([1, 2, 3, 4, 5]);
    var last = a.next.next;
    last.next = a;
    expect(cyclical(a)).toBeTruthy();
  });
});
