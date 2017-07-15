/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 *
 * Input : Given dictionary = [ "deer", "door", "cake", "card" ]
 *
 * isUnique("dear") ->
 * false
 * isUnique("cart") ->
 * true
 * isUnique("cane") ->
 * false
 * isUnique("make") ->
 * true
 *
 * this problem can be hard if you don't think about the edge cases. The key part is to know what makes the word true or false and
 * read the problem carefully when writing the code. Becauuse I had to restart since I didn't read it carefully.
 * Complexity : O(N) time, O(N) space
 */

public class ValidWordAbbr {
  HashMap<String, String> map;
  public ValidWordAbbr(String[] dictionary) {
    map = new HashMap<String, String>();
    for (String s : dictionary) {
      if (!s.isEmpty()){
        String key  = s.charAt(0) +""+ (s.length() - 2) +""+ s.charAt(s.length() - 1) +"";
        if (!map.containsKey(key)) {
          map.put(key, s);
        } else {
          if (!map.get(key).equals(s)) {
            map.put(key, "");
          }
        }
      }
    }
  }
  public boolean isUnique(String word) {
    if (word.isEmpty()) return true;
    String key = word.charAt(0) +""+ (word.length() - 2) +""+ word.charAt(word.length() - 1) +"";
    System.out.println(key);
    return !map.containsKey(key)|| map.get(key).equals(word);
  }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
