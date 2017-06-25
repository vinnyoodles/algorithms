/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters. 
 * For example, given s = "eceba" and k = 2,
 * T is "ece" which has a length of 3 and 2 distinct characters.
 */
public class Solution {
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k == 0) return 0;
    if (s.length() == 0 || s.length() == 1) return s.length();

    int i = 0; 
    int j = 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int distinct = 0;
    int maxLength = 0;

    while (j < s.length()) {
      char next = s.charAt(j);
      int count = map.get(next) != null && map.get(next) > 0 ? map.get(next) : 0;
      map.put(next, count + 1);
      if (count == 0) distinct ++;

      // The number of distinct character is equal to K so we must remove a distinct character and all of its occurences.
      // The distinct chararcter that is removed is dependent on whichever reaches a frequency of 0 first.
      if (distinct > k) {
        char start = s.charAt(i);

        // Keep moving the beginning pointer until a character frequency is 0
        while (i < j && map.get(s.charAt(i)) != null && map.get(s.charAt(i)) - 1 > 0) {
          map.put(s.charAt(i), map.get(s.charAt(i++)) - 1);
        }

        // Remove the last character.
        map.put(s.charAt((++i) - 1), 0);
        distinct --;
      }

      maxLength = Math.max(maxLength, j - i + 1);
      j ++;
    }

    return maxLength;
  } 
}
