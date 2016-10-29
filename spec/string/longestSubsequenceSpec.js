var subsequence = require('../../src/string/longestSubsequence');

describe('longestSubsequence', () => {
  it('should return the length of the longest subsequence of two strings', () => {
    var string1 = 'abc';
    var string2 = 'abdace';
    expect(subsequence(string1, string2)).toEqual(3);
  });

  it('should return the length of identical strings', () => {
    var string1 = 'aaaabcccc';
    expect(subsequence(string1, string1)).toEqual(string1.length);
  });

  it('should work for long strings', () => {
    var string1 = 'aaaabcccc';
    var string2 = 'abbcacdbacbaddbcadbcabdcabdc';
    expect(subsequence(string1, string2)).toEqual(9);
  });
});
