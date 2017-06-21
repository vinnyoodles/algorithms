/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Complexity : O(n) time, O(n) space
 */
public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int j = 0; // front pointer
    int i = 0; // back pointer
    int size = s.length();
    HashSet<Character> set = new HashSet<Character>();
    int result = 0;
    while ( i < size && j < size) {
      // adds only the unique values
      if (!set.contains(s.charAt(i))) {
        // Move the back pointer, increasing the substring length.
        i++;
        set.add(s.charAt(i - 1));
        // i - j, since that will give use the length of the substring
        result = Math.max(result, i - j);
      } else {
        // Move the front pointer, decreasing the substring length.
        j++;
        set.remove(s.charAt(j - 1));
      }
    }
    return result;
  }
}
