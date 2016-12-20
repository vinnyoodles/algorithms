var DoublyListNode = require('../../src/linkedlist/DoublyListNode');

describe('DoublyListNode', () => {
  describe('constructor', () => {
    it('should create a node with the value', () => {
      var a = new DoublyListNode(1);
      expect(a.value).toEqual(1);
      expect(a.toArray()).toEqual([1]);
    });

    it('should create an entire list with an array', () => {
      var head = new DoublyListNode([1, 2, 3, 4, 5]);
      expect(head.toArray()).toEqual([1, 2, 3, 4, 5]);
      expect(head.next.value).toEqual(2);
      expect(head.next.prev.value).toEqual(1);
      expect(head.next.next.value).toEqual(3);
      expect(head.next.next.prev.value).toEqual(2);
      expect(head.next.next.next.value).toEqual(4);
      expect(head.next.next.next.prev.value).toEqual(3);
      expect(head.next.next.next.next.value).toEqual(5);
      expect(head.next.next.next.next.prev.value).toEqual(4);
      expect(head.next.next.next.next.next).toBeFalsy(null);
    });
  });

  describe('removeFromList', () => {
    it('should remove a middle node from the list', () => {
      var head = new DoublyListNode([1, 2, 3, 4, 5]);
      var middle = head.next.next;
      middle.removeFromList();
      expect(head.toArray()).toEqual([1, 2, 4, 5]);
      expect(middle.toArray()).toEqual([3]);
    });

    it('should remove a head node from the list', () => {
      var head = new DoublyListNode([1, 2, 3, 4, 5]);
      var second = head.next;
      head.removeFromList();
      expect(second.toArray()).toEqual([2, 3, 4, 5]);
      expect(head.toArray()).toEqual([1]);
    });

    it('should remove a head node from the list', () => {
      var head = new DoublyListNode([1, 2, 3, 4, 5]);
      var tail = head.next.next.next.next;
      tail.removeFromList();
      expect(head.toArray()).toEqual([1, 2, 3, 4]);
      expect(tail.toArray()).toEqual([5]);
    });
  });
});
