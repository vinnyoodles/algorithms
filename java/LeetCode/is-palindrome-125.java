/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class Solution {
  public boolean isPalindrome(String s) {
    if (s.length() == 0) return true;
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      char a = s.charAt(i);
      char b = s.charAt(j);
      if (isValid(a) && isValid(b)) {
        if (Character.toLowerCase(a) != Character.toLowerCase(b)) return false;
        i ++;
        j --;
        continue;
      }

      if (!isValid(s.charAt(i))) while (i < s.length() && !isValid(s.charAt(i))) i ++;

      if (!isValid(s.charAt(j))) while (j >= 0 && !isValid(s.charAt(j))) j --;
    }
    return true;

  }

  public boolean isValid(Character c) {
    return Character.isLetter(c) || Character.isDigit(c);
  }
}
