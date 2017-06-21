var longestSubstring = require('../../javascript/string/longestSubstring');

describe('longestSubstring', () => {
  it('should return the longest substring', () => {
    expect(longestSubstring('abcde')).toEqual(5);
    expect(longestSubstring('aabbc')).toEqual(2);
    expect(longestSubstring('aabcde')).toEqual(5);
    expect(longestSubstring('abcacder')).toEqual(5);
    expect(longestSubstring('abcabacade')).toEqual(4);
  });
});