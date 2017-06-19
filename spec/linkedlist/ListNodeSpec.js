var ListNode = require('../../javascript/linkedlist/ListNode');

describe('ListNode', () => {
  describe('constructor', () => {
    it('should create a node with the value', () => {
      var a = new ListNode(1);
      expect(a.value).toEqual(1);
    });

    it('should create an entire list with an array', () => {
      var head = new ListNode([1, 2, 3, 4, 5]);
      expect(head.toArray()).toEqual([1, 2, 3, 4, 5]);
    });
  });

  describe('append', () => {
    it('should add a single value to the end of the list', () => {
      var head = new ListNode(1);
      head.append(2);
      head.append(3);
      expect(head.value).toEqual(1);
      expect(head.next.value).toEqual(2);
      expect(head.next.next.value).toEqual(3);
    });

    it('should add an array of values to the end of the list', () => {
      var head = new ListNode(1);
      head.append([2, 3, 4]);
      head.append([5, 6]);
      expect(head.value).toEqual(1);
      expect(head.next.value).toEqual(2);
      expect(head.next.next.value).toEqual(3);
      expect(head.next.next.next.value).toEqual(4);
      expect(head.next.next.next.next.value).toEqual(5);
      expect(head.next.next.next.next.next.value).toEqual(6);
    });

    it('should work for empty arrays', () => {
      var head = new ListNode(1);
      head.append([]);
      expect(head.toArray()).toEqual([1]);
      expect(head.value).toEqual(1);
      expect(head.next).toBeFalsy();
    });

    it('should return the last node added', () => {
      var head = new ListNode(1);
      var last = head.append([2, 3, 4]);
      expect(head.value).toEqual(1);
      expect(last.value).toEqual(4);
    });
  });

  describe('toArray', () => {
    it('should return an array representing the linked list', () => {
      var head = new ListNode(1);
      head.append([2, 3, 4]);
      expect(head.toArray()).toEqual([1, 2, 3, 4]);
    });

    it('should work for lists of 1 node', () => {
      var head = new ListNode(1);
      expect(head.toArray()).toEqual([1]);
    });
  });

  describe('findNode', () => {
    it('should return the node before the search node', () => {
      var head = new ListNode(1);
      var second = head.next = new ListNode(2);
      var third = second.next = new ListNode(3);
      expect(head.findNode(third)).toEqual(second);
    });

    it('should work when the node is in the middle', () => {
      var head = new ListNode(1);
      var second = head.next = new ListNode(2);
      var third = second.next = new ListNode(3);
      third.next = new ListNode(4);
      expect(head.findNode(third)).toEqual(second);
    });

    it('should return null when not found', () => {
      var head = new ListNode(1);
      var second = head.next = new ListNode(2);
      var third = second.next = new ListNode(3);
      third.next = new ListNode(4);
      var loner = new ListNode(5);
      expect(head.findNode(loner)).toEqual(null);
    });
  });

  describe('removeLast', () => {
    it('should remove the last node in the list', () => {
      var head = new ListNode(1);
      head.append([2, 3, 4]);
      expect(head.removeLast().value).toEqual(4);
      expect(head.toArray()).toEqual([1, 2, 3]);
    });

    it('should remove the head node if the list contains just the head node', () => {
      var head = new ListNode(1);
      expect(head.removeLast().value).toEqual(null);
      expect(head.toArray()).toEqual([]);
    });

  });
});
