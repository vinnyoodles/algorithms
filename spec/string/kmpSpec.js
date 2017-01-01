var { kmp, createTable } = require('../../src/string/kmp');

describe('kmp', () => {
  describe('main', () => {
    it('should return the start index if found', () => {
      expect(kmp('abc abcdab abcdabcdabde','abcdabd')).toEqual(15);
      expect(kmp('participate in parachute','abcdabd')).toEqual(-1);
      expect(kmp('participate in parachute','para')).toEqual(15);
      expect(kmp('participate in parachute','par')).toEqual(0);
    });
  });

  describe('createTable', () => {
    it('should create a fail table given a target string', () => {
      expect(createTable('abcdabd')).toEqual([-1, 0, 0, 0, 0, 1, 2, 0]);
      expect(createTable('abcdefg')).toEqual([-1, 0, 0, 0, 0, 0, 0, 0]);
      expect(createTable('abcdeab')).toEqual([-1, 0, 0, 0, 0, 0, 1, 2]);
      expect(createTable('abcdeabc')).toEqual([-1, 0, 0, 0, 0, 0, 1, 2, 3]);
      expect(createTable('abcdeabce')).toEqual([-1, 0, 0, 0, 0, 0, 1, 2, 3, 0]);
      expect(createTable('abcdeabczxc')).toEqual([-1, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0]);
      expect(createTable('123')).toEqual([-1, 0, 0, 0]);
      expect(createTable('abcakjdasdkjakjdklajabcajkldajsdkljaslj')).toEqual([-1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 2, 3, 4, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0]);
      expect(createTable('participate in parachute')).toEqual([-1,0,0,0,0,0,0,0,1,2,0,0,0,0,0,0,1,2,3,0,0,0,0,0,0]);
    });
  });
});
