import java.util.*;
/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters. 
 * For example, given s = "ecceba" and k = 2,
 * T is "ece" which has a length of 3 and 2 distinct characters.
 */
public class Solution {
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s.length() == 0 || s.length() == 1) return s.length();
    if (k == 0) return 0;

    int i = 0; 
    int j = 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int distinct = 0;
    int maxLength = 0;

    while (j < s.length()) {
      char next = s.charAt(j);

      int count = map.get(next) != null && map.get(next) > 0 ? map.get(next) : 0;
      // System.out.println("1: " +  map);
      map.put(next, count + 1);
      if (count == 0) distinct ++;

      // The number of distinct character is equal to K so we must remove the first distinct characters from the front.
      // Also update the max length.
      if (distinct > k) {
        char start = s.charAt(i);

        // Keep moving the beginning pointer until a character frequency is 0
        while (i < j && map.get(s.charAt(i)) != null && map.get(s.charAt(i)) - 1 > 0) {
          // System.out.println("2: " +  map + ", " + map.get(s.charAt(i)));
          map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
          i ++;
          // System.out.println("2.5: " +  map);
        }

        // Remove the last character.
      // System.out.println("3: " +  map);
      i++;
        map.put(s.charAt(i - 1), 0);
        distinct --;
      }

      // System.out.println(i + ", " + j + ", " + k);
      maxLength = Math.max(maxLength, j - i + 1);
      j ++;
    }

    return maxLength;
  } 

  public static void main(String[] args) {
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("ababacccccc", 2) + ", " + 7);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("ccaabbb", 2) + ", " + 5);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("ccaabbb", 3) + ", " + 7);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("abaccc", 2) + ", " + 4);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("ab", 1) + ", " + 1);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("ab", 2) + ", " + 2);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("aabbcc", 1) + ", " + 2);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("aabbcc", 2) + ", " + 4);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("aabbcc", 3) + ", " + 6);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("aaabbb", 3) + ", " + 6);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("ripasdses", 4) + ", " + 6);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("eceba", 2) + ", " + 3);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("asdjkakdlakdakljsdkl", 10) + ", " + 20);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("aaaaaaaaaaaaaaaaaaaa", 1) + ", " + 20);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("abcdaaa", 2) + ", " + 4);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("qweaaaaaaaaaaartyuiop", 2) + ", " + 12);
    System.out.println("Answer: " + lengthOfLongestSubstringKDistinct("zxcvaaaaabbbnm", 3) + ", " + 9);
  }
}

