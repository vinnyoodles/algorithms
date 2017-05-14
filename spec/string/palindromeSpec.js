var isPalindrome = require('../../src/string/palindrome');

describe('isPalindrome', () => {
  it('should return true for valid palindromes', () => {
    expect(isPalindrome('cac')).toBeTruthy();
    expect(isPalindrome('aba')).toBeTruthy();
    expect(isPalindrome('abba')).toBeTruthy();
    expect(isPalindrome('aaaa')).toBeTruthy();
    expect(isPalindrome('aaa')).toBeTruthy();
    expect(isPalindrome('abcba')).toBeTruthy();
    expect(isPalindrome('c')).toBeTruthy();
  });

  it('should return false for invalid palindromes', () => {
    expect(isPalindrome('cat')).toBeFalsy();
    expect(isPalindrome('')).toBeFalsy();
    expect(isPalindrome('askdjsalkjdklasj')).toBeFalsy();
  });
});
