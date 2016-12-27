var balanced = require('../../src/string/balancedParentheses');

describe('balancedParentheses', () => {
  it('should return true for a valid expression', () => {
    expect(balanced('[{()}]')).toBeTruthy();
    expect(balanced('{}[]()')).toBeTruthy();
    expect(balanced('{{{{{{{{{{}}}}}}}}}}')).toBeTruthy();
    expect(balanced('(((((((((((((((((())))))))))))))))))')).toBeTruthy();
    expect(balanced('[[[[[[[[[[[[[[[[[[[[[[[[{{{{{{{}}}}}}}[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]')).toBeTruthy();
    expect(balanced('[[[[[[[[[[[[[[[[[[[[[[[[{{{{{{{}}}}}}}[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]](((((((((())))))))))]]]]]]]]]]]]]]]]]')).toBeTruthy();
    expect(balanced('{}()[{}]')).toBeTruthy();
    expect(balanced('{}({{{{((((([[[[]]]])))))}}}})[{}]')).toBeTruthy();
  });

  it('should return false for an invalid expression', () => {
    expect(balanced('[[[[[[]]]]]')).toBeFalsy();
    expect(balanced('{{{{{)}}}}')).toBeFalsy();
    expect(balanced('abc')).toBeFalsy();
    expect(balanced('d')).toBeFalsy();
    expect(balanced()).toBeFalsy();
    expect(balanced(null)).toBeFalsy();
    expect(balanced('[]{}(')).toBeFalsy();
    expect(balanced('{{{{{(}((([[[]]])))))}}}}}')).toBeFalsy();
    expect(balanced('[[[[[[[[[[[[[[[[[[[[[[[[{{{{{{{}}}}}}}[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]')).toBeFalsy();
    expect(balanced('}{}')).toBeFalsy();
    expect(balanced('{{}')).toBeFalsy();
    expect(balanced('{()})')).toBeFalsy();
    expect(balanced('{(})')).toBeFalsy();
    expect(balanced('[]{(})')).toBeFalsy();
    expect(balanced('[{(})')).toBeFalsy();
  });
});
