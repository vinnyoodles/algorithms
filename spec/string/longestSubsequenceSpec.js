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

  it('should return 0 when no subsequence exists', () => {
    var string1 = 'abcd';
    var string2 = 'xyz';
    expect(subsequence(string1, string2)).toEqual(0);
  });

  it('should count whitespace', () => {
    var string1 = 'tttttttttttttttttttt abc wwwwwwwwwwwwwww';
    var string2 = 'zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz abc zzzzzzzzzzzzzzzzzzz';
    expect(subsequence(string1, string2)).toEqual(5);
  });

  it('should match the subsequence found at the end', () => {
    var string1 = 'qweeeeeeeeeeeeeeeeqweqweqweqweqweqweqweqweqwqweqwqweqweqwabc';
    var string2 = 'popopopopopioiopioppoipiipoioopipoipoipoipoipoipoiabc';
    expect(subsequence(string1, string2)).toEqual(3);
  });

  it('should match the subsequence found at the beginning', () => {
    var string1 = 'abcqweeeeeeeeeeeeeeeeqweqweqweqweqweqweqweqweqwqweqwqweqweqw';
    var string2 = 'abcpopopopopopioiopioppoipiipoioopipoipoipoipoipoipoi';
    expect(subsequence(string1, string2)).toEqual(3);
  });

  it('should not have to be continuous', () => {
    var string1 = 'zzzzzzzazzzzzzbzzzzzzc';
    var string2 = 'tttttabctttt';
    expect(subsequence(string1, string2)).toEqual(3);
    var string3 = 'zzzzzzzazzzzzzbzzzzzzc';
    var string4 = 'ttttatttttbttttc';
    expect(subsequence(string3, string4)).toEqual(3);
    var string5 = 'zzzzzzabczzzzz';
    var string6 = 'ttttatttttbttttc';
    expect(subsequence(string5, string6)).toEqual(3);
  });
});
