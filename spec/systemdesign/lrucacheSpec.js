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
