/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Complexity: O(N) time and space.
 * Note: there is a nested loop, but it is still O(N) time because 
 * the sum of all the counts is equal to the length of the initial string.
 */
public class Solution {
  public String frequencySort(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    // Get the count of each character.
    for (char c: s.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1) ;
      } else {
        map.put(c, 1);
      }
    }

    // An array of stringbuilders where the index is equal to the count/frequence of those characters.
    StringBuilder[] arr = new StringBuilder[s.length()];

    // Prepopulate all the stringbuilders.
    for (int i = 0; i < s.length(); i ++) arr[i] = new StringBuilder();

    // Iterate through the map of character counts
    for (char key: map.keySet()) {
      int count = map.get(key);

      // Append the character, count times, into the corresponding stringbuilder.
      for (int i = 0; i < count; i ++) {
        arr[count - 1].append(key);
      }
    }

    // Create the final stringbuilder
    StringBuilder b = new StringBuilder();
    for (StringBuilder temp: arr) {
      b.append(temp.toString());
    }

    // Reverse because of decreasing order.
    return b.reverse().toString();
  }
}
