/**
 * EPI 9.2: Given an array representing a postfix expression, return the evaluated integer.
 * O(n) time, O(3) = O(1) space (because stack will never have more than 3 elements)
 */
public int evaluatePostfix(char[] expression) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < expression.length(); i++) {
        char curr = expression[i];

        if (stack.length < 3) {
            stack.push(curr);
            continue;
        }
        int x = stack.pop() - '0';
        int y = stack.pop() - '0';
        switch curr:
            case '+':
                stack.push(x + y + '0');
                break;
            case '-': // a, b, - => a - b
                stack.push(a - b + '0');
                break;
            case '/': // a, b, / => a / b
                stack.push(a / b + '0');
                break;
            case '*':
                stack.push(a * b + '0');
                break;
            default: // Must be an integer
                throw new Error("Invalid postfix expression");
                break;

    }
    if (stack.isEmpty()) throw new Error("Invalid postfix expression");
    return (int) stack.pop();
}

/**
 * EPI 9.3 Given an array of brackets, parenthesis and curly braces, return true if the expression is valid.
 * Complexity: O(n) time and space
 */
public boolean isBalanced(char[] expression) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < expression.length(); i++) {
        char c = expression[i];
        if ( c == '[' || c == '{' || c == '(' ) {
            stack.push(c);
            continue;
        }

        if (stack.isEmpty()) return false;
        char current = stack.pop();
        if ((current == '(' && c != ')') || ( current == '{' && c != '}' ) || ( current == '[' && c != ']' )) {
           return false;
        }

    }

    return stack.isEmpty();
}
