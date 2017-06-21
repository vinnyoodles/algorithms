/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters. 
 * For example, given s = "ecceba" and k = 2,
 * T is "ece" which has a length of 3 and 2 distinct characters.
 */
public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s.length() == 0 || (s.length() == 1 && k == 1)) return s.length();
    if (s.length() == 1 && k > 1) return 0;

    int i = 0; 
    int j = 1;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int distinct = s.charAt(i) == s.charAt(j) ? 1 : 2;
    int maxLength = 0;
    map.put(s.charAt(i), 1);
    map.put(s.charAt(j), distinct);

    while (i < j && j < s.length() - 1) {
      char next = s.charAt(j + 1);
      // The number of distinct character is equal to K so we must remove the first distinct characters from the front.
      if (distinct > k) {
        char start = s.charAt(i);
        while (i < s.length() && start == s.charAt(i)) { 
          i ++;
          map.put(start, Math.max(0, map.containsKey(start) ? map.get(start) - 1 : 0));
        }

        distinct --;
      } else {
        maxLength = Math.max(maxLength, j - i + 1);
      }

      int count = map.containsKey(next) ? map.get(next) : 0;
      distinct = count != 0 ? distinct : distinct + 1; 
      map.put(next, count + 1);
      j ++;
    }

    return distinct > k ? maxLength : Math.max(maxLength, j - i + 1);
  } 
}
