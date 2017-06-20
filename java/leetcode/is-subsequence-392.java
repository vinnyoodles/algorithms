/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. 
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting some 
 * (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class Solution {
  public boolean isSubsequence(String s, String t) {
    // An empty string is a subsequence of everything.
    if (s.length() == 0) return true;
    // There are no subsequences of an empty string.
    if (t.length() == 0) return false;

    int k = 0;
    for (int i = 0; i < t.length(); i ++) {
      if (t.charAt(i) == s.charAt(k)) k ++;
      if (k >= s.length()) return true;
    }

    return k >= s.length();
  }
}