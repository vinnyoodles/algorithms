// The following hash tables are used for simpler character comparison.
const OPENED_TO_CLOSED = {
  '{': '}',
  '[': ']',
  '(': ')'
};

const CLOSED_TO_OPENED = {
  '}': '{',
  ']': '[',
  ')': '(',
};

function balancedParentheses(expression) {
  if (!expression) return false;

  var stack = [];
  for (var i in expression) {
    var char = expression[i];
    if (OPENED_TO_CLOSED[char]) {
      // If the character is an opening parentheses, then add it to the stack.
      stack.push(char);
    } else if (CLOSED_TO_OPENED[char]) {
      // If the character is a closing parentheses, then compare it to the end of the stack.
      if (CLOSED_TO_OPENED[char] !== stack[stack.length - 1]) return false;
      stack.pop();
    } else {
      // This is an invalid character.
      return false;
    }
  }

  // The expression is balanced if the stack is empty in the end.
  return !stack.length;
}

module.exports = balancedParentheses;
