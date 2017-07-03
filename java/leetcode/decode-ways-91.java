/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 */
public class Solution {
  public int numDecodings(String s) {
    if (s.equals("0")) return 0;
    if (s.length() <= 1) return s.length();
    return helper(s, 0, new int[s.length()]);
  }

  public int helper(String s, int i, int[] memo) {
    if (i >= s.length()) return 1;
    if (s.charAt(i) == '0') return 0;
    if (memo[i] > 0) return memo[i];

    int count = helper(s, i + 1, memo);
    if (i == s.length() - 1) {
      memo[i] = count;
      return count;
    }

    int doubledigit = Integer.parseInt(s.substring(i, i + 2));
    if (doubledigit <= 26) {
      count += helper(s, i + 2, memo);
    }
    memo[i] = count;
    return count;
  }
}