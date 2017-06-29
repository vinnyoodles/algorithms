/**
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Input/Output
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * Complexity: O(N) time, N is the length of the decoded string
 * O(N) space, N is the length of the decoded string
 */
public class Solution {
  public String decodeString(String s) {
    Stack<Integer> repeatValue = new Stack<Integer>();
    Stack<String> str = new Stack<String>();
    int index = 0;
    String res = "";
    while (index < s.length()) {
      char c = s.charAt(index);
      if (Character.isDigit(c)) {
        int start = index;
        while (Character.isDigit(c)) {
          index++;
          c = s.charAt(index);
        }
        int val = Integer.parseInt(s.substring(start, index));
        repeatValue.push(val);
        c = s.charAt(index);
      }
      if (c == '[') {
        // want to push our string we made
        str.push(res);
        res = "";
      } else if (c == ']') {
        int repeat = repeatValue.pop();
        // get our resultString
        StringBuilder b = new StringBuilder(str.pop());
        for (int i = 0; i < repeat; i++) {
          b.append(res);
        }
        res = b.toString();
      } else {
        res += c;
      }
      index++;
    }
    return res;
  }
}
