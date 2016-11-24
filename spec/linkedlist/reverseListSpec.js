var ListNode = require('../../src/linkedlist/ListNode');
var reverseList = require('../../src/linkedlist/reverseList');

describe('reverseList', () => {
  it('should reverse a linked list', () => {
    var a = new ListNode(1);
    a.append([2, 3, 4, 5, 6]);
    expect(reverseList(a).toArray()).toEqual([6, 5, 4, 3, 2, 1]);
  });

  it('should reverse a linked list', () => {
    var a = new ListNode(1);
    expect(reverseList(a).toArray()).toEqual([1]);
  });

  it('should reverse a linked list', () => {
    var a = new ListNode(1);
    a.append([123,12,312,3,123,4151,23,14,13,13,1,4215,34,6,67,4321,456,32,145,6321,4534,2,13,534,2421,36,523414,23,634,6521,412,532,53]);
    expect(reverseList(a).toArray()).toEqual([53,532,412,6521,634,23,523414,36,2421,534,13,2,4534,6321,145,32,456,4321,67,6,34,4215,1,13,13,14,23,4151,123,3,312,12,123,1]);
  });
});
