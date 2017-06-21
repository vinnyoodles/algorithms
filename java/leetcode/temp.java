/**
 * Now you are given a string S, which represents a software license key which we would like to format. 
 * The string S is composed of alphanumerical characters and dashes. 
 * The dashes split the alphanumerical characters within the string into groups. 
 * (i.e. if there are M dashes, the string is split into M+1 groups). 
 * The dashes in the given string are possibly misplaced.
 * We want each group of characters to be of length K (except for possibly the first group, which could be shorter, but still must contain at least one character).
 * To satisfy this requirement, we will reinsert dashes. Additionally, all the lower case letters in the string must be converted to upper case.
 * So, you are given a non-empty string S, representing a license key to format, and an integer K. 
 * And you need to return the license key formatted according to the description above.
 * 
 * Input: S = "2-4A0r7-4k", K = 4
 * Output: "24A0-R74K" 
 * Complexity: time is O(n), space is O(n)
 */
public class Solution {
  public String licenseKeyFormatting(String S, int K) {
    Stack<Character> s = new Stack<Character>(); 
    int s_Size = S.length() - 1; 
    int split_Count = 0;
    while (s_Size >= 0) {
      if (S.charAt(s_Size) == '-') {
        s_Size--;
      } else {
        if (split_Count != K) {
          s.push(S.charAt(s_Size));
          split_Count++;
          s_Size--;
        } else {
          s.push('-');
          split_Count = 0;
        }
      }
    }

    StringBuilder res = new StringBuilder();
    while(!s.isEmpty()) {
      res.append(s.pop());
    }

    return res.toString().toUpperCase();
  }
}
