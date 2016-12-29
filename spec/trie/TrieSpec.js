var Trie = require('../../src/trie');

describe('trie', () => {
  it('should create a trie structure', () => {
    var trie = new Trie();
    trie.insert('skywalker');
    expect(trie.toArray()).toEqual(['skywalker']);
  });

  it('should create with multiple words', () => {
    var trie = new Trie();
    trie.insert('summer');
    trie.insert('super');
    trie.insert('soon');
    trie.insert('sorry');
    trie.insert('sandy');
    trie.insert('solstice');
    expect(trie.toArray()).toEqual(['summer', 'super', 'soon', 'sorry', 'solstice', 'sandy']);
  });

  it('should return any partial matches', () => {
    var trie = new Trie();
    trie.insert('try');
    trie.insert('tree');
    trie.insert('tar');
    trie.insert('trek');
    trie.insert('tar');
    trie.insert('terrible');
    trie.insert('ten');
    trie.insert('tupperware');
    trie.insert('tickle');
    trie.insert('taboo');
    trie.insert('tenacious');
    expect(trie.match('te')).toEqual(['terrible', 'ten', 'tenacious']);
    expect(trie.match('tr')).toEqual(['try', 'tree', 'trek']);
    expect(trie.match('tenacious')).toEqual(['tenacious']);
    expect(trie.match('no match')).toEqual([]);
  });

  it('should return if the word is contained in the trie', () => {
    var trie = new Trie();
    trie.insert('apple');
    trie.insert('banana');
    trie.insert('orange');
    trie.insert('berry');
    trie.insert('pineapple');
    trie.insert('strawberry');
    trie.insert('lime');
    trie.insert('mango');
    trie.insert('fruit');
    trie.insert('tomato');
    trie.insert('potato');
    expect(trie.search('apple')).toBeTruthy();
    expect(trie.search('pineapple')).toBeTruthy();
    expect(trie.search('strawberry')).toBeTruthy();
    expect(trie.search('potato')).toBeTruthy();
    expect(trie.search('pine')).toBeFalsy();
    expect(trie.search('')).toBeFalsy();
    expect(trie.search('foo')).toBeFalsy();
    expect(trie.search('bar')).toBeFalsy();
    expect(trie.search('this is a very long string, blabbity bla bla')).toBeFalsy();
    expect(trie.search('straw')).toBeFalsy();
  });

  it('should pass leetcode1', () => {
    var trie = new Trie();
    trie.insert('hello');
    expect(trie.search('hell')).toBeFalsy();
    expect(trie.search('helloa')).toBeFalsy();
    expect(trie.search('hello')).toBeTruthy();
    expect(trie.match('hell')).toEqual(['hello']);
    expect(trie.match('helloa')).toEqual([]);
    expect(trie.match('hello')).toEqual(['hello']);
  });
});
