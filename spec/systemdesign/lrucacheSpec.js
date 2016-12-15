var LRUCache = require('../../src/systemdesign/lrucache');

describe('LRUCache', () => {
  beforeEach(() => {
    this.cache = new LRUCache(3);
  });

  describe('get', () => {
    it('should get the correct value with the key', () => {
      this.cache.set('key1', 1);
      this.cache.set('key2', 2);
      expect(this.cache.get('key1')).toEqual(1);
      expect(this.cache.get('key2')).toEqual(2);
    });

    it('should return null if the key does not exist', () => {
      this.cache.set('key1', 1);
      expect(this.cache.get('key2')).toEqual(null);
    });

    it('should update the selected node', () => {
      this.cache.set('key1', 1);
      this.cache.set('key2', 2);
      this.cache.set('key3', 3);
      expect(this.cache._head.toArray()).toEqual([3, 2, 1]);
      expect(this.cache.get('key3')).toEqual(3);
      expect(this.cache.get('key2')).toEqual(2);
      expect(this.cache.get('key1')).toEqual(1);
      expect(this.cache._head.toArray()).toEqual([1, 2, 3]);
      expect(this.cache.get('key2')).toEqual(2);
      expect(this.cache._head.toArray()).toEqual([2, 1, 3]);
      expect(this.cache.get('key3')).toEqual(3);
      expect(this.cache._head.toArray()).toEqual([3, 2, 1]);
      expect(this.cache.get('key1')).toEqual(1);
      expect(this.cache._head.toArray()).toEqual([1, 3, 2]);
      expect(this.cache.get('key1')).toEqual(1);
      expect(this.cache._head.toArray()).toEqual([1, 3, 2]);
      expect(this.cache.get('key2')).toEqual(2);
      expect(this.cache._head.toArray()).toEqual([2, 1, 3]);
      expect(this.cache.get('key1')).toEqual(1);
      expect(this.cache._head.toArray()).toEqual([1, 2, 3]);
    });

    it('should pass leetcode 1', () => {
      var cache = new LRUCache(2);
      expect(cache.get(2)).toEqual(null);
      cache.set('2', 6);
      expect(cache.get(1)).toEqual(null);
      cache.set('1', 5);
      cache.set('1', 2);
      expect(cache.get(1)).toEqual(2);
      expect(cache.get(2)).toEqual(6);
    });

    it('should pass leetcode 2', () => {
      var cache = new LRUCache(10);
      var output = [];
      cache.set(10,13);
      cache.set(3,17);
      cache.set(6,11);
      cache.set(10,5);
      cache.set(9,10);
      output.push(cache.get(13)); // null
      cache.set(2,19);
      output.push(cache.get(2)); // 19
      output.push(cache.get(3)); // 17
      cache.set(5,25);
      output.push(cache.get(8)); // null
      cache.set(9,22);
      cache.set(5,5);
      cache.set(1,30);
      output.push(cache.get(11)); // null
      cache.set(9,12);
      output.push(cache.get(7)); // null
      output.push(cache.get(5)); // 5
      output.push(cache.get(8)); // null
      output.push(cache.get(9)); // 12
      cache.set(4,30);
      cache.set(9,3);
      output.push(cache.get(9)); // 3
      output.push(cache.get(10)); // 5
      output.push(cache.get(10)); // 5
      cache.set(6,14);
      cache.set(3,1);
      output.push(cache.get(3)); // 1
      cache.set(10,11);
      output.push(cache.get(8)); // null
      cache.set(2,14);
      output.push(cache.get(1)); // 30
      output.push(cache.get(5)); // 5
      output.push(cache.get(4)); // 30
      cache.set(11, 4);
      cache.set(12,24);
      cache.set(5,18);
      output.push(cache.get(13)); // null
      cache.set(7,23);
      output.push(cache.get(8)); // null
      output.push(cache.get(12)); // 24
      cache.set(3,27);
      cache.set(2,12);
      output.push(cache.get(5)); // 18
      cache.set(2,  9);
      cache.set(13,4);
      cache.set(8,18);
      cache.set(1,7);
      output.push(cache.get(6)); // null
      cache.set(9, 29);
      cache.set(8, 21);
      output.push(cache.get(5)); // 18
      cache.set(6,30);
      cache.set(1,12);
      output.push(cache.get(10)); // null
      cache.set(4, 15);
      cache.set(7,22);
      cache.set(11, 26);
      cache.set(8, 17);
      cache.set(9, 29);
      output.push(cache.get(5)); // 18
      cache.set(3, 4);
      cache.set(11, 30);
      output.push(cache.get(12)); // null
      cache.set(4, 29);
      output.push(cache.get(3)); // 4
      output.push(cache.get(9)); // 29
      output.push(cache.get(6)); // 30
      cache.set(3,4);
      output.push(cache.get(1)); // 12
      output.push(cache.get(10)); // null
      cache.set(3,29);
      cache.set(10,28);
      cache.set(1,20);
      cache.set(11,13);
      output.push(cache.get(3)); // 29
      cache.set(3,12);
      cache.set(3,8);
      cache.set(10,9);
      cache.set(3,26);
      output.push(cache.get(8)); // 17
      output.push(cache.get(7)); // 22
      output.push(cache.get(5)); // 18
      cache.set(13,17);
      cache.set(2,27);
      cache.set(11,15);
      output.push(cache.get(12)); // null
      cache.set(9,19);
      cache.set(2,15);
      cache.set(3,16);
      output.push(cache.get(1)); // 20
      cache.set(12,17);
      cache.set(9,1);
      cache.set(6,19);
      output.push(cache.get(4)); // null
      output.push(cache.get(5)); // 18
      output.push(cache.get(5)); // 18
      cache.set(8,1);
      cache.set(11,7);
      cache.set(5,2);
      cache.set(9,28);
      output.push(cache.get(1)); //20
      expect(output.length).toEqual(41);
      expect(output).toEqual([null, 19, 17, null, null, null, 5, null, 12, 3, 5, 5, 1, null, 30, 5, 30, null, null, 24, 18, null, 18, null, 18, null, 4, 29, 30, 12, null, 29, 17, 22, 18, null, 20, null, 18, 18, 20]);
    });
  });

  describe('set', () => {
    it('should set the value under the key', () => {
      this.cache.set('key1', 1);
      expect(this.cache.get('key1')).toEqual(1);
    });

    it('should evict the least used node', () => {
      this.cache.set('key1', 1);
      this.cache.set('key2', 2);
      this.cache.set('key3', 3);
      expect(this.cache._head.toArray()).toEqual([3, 2, 1]);
      this.cache.set('key4', 4);
      expect(this.cache._head.toArray()).toEqual([4, 3, 2]);
      this.cache.set('key5', 5);
      expect(this.cache._head.toArray()).toEqual([5, 4, 3]);
    });

    it('should overwrite the key', () => {});
  });
});
