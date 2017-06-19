var longestPalindrome = require('../../javascript/string/longestPalindrome');

describe('longestPalindrome', () => {
  it('should return the longest palindrome', () => {
    expect(longestPalindrome('babad')).toEqual('bab');
    expect(longestPalindrome('aslkdjlaksjdklasjdklracecarasjlkdjaslkdjskla')).toEqual('racecar');
    expect(longestPalindrome('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbcccddddddddddd'))
     .toEqual('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
    expect(longestPalindrome('aaaabaaa')).toEqual('aaabaaa');
  });
});
