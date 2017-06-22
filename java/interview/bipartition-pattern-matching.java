/**
 * @Company Facebook
 *
 * Given two strings, str and pattern, return true if the str has a valid mapping between the words in str and the characters in the pattern.
 * The str will be whitespace separated and the pattern will be depicted using characters.
 *
 * Problem Ex.
 *   Input: 'cat dog dog cat', 'abba'
 *   Output: true because cat = a and dog = b.
 *
 *   Input: 'cat dog dog foo', 'abba'
 *   Output: false because cat = a so foo cannot == a
 */
public boolean wordPattern(String str, String pattern) {
  // map each letter to a string.
  String[] strs = str.split("\\s");
  // character -> string mapping
  String[] map = new String[26];
  HashSet<String> set = new HashSet<String>();

  // Must be equal in length.
  if (strs.length != pattern.length()) return false;

  for (int i = 0; i < strs.length; i ++) {
    String string = strs[i];
    char c = pattern.charAt(i);
    int index = c - 'a';

    // First occurence of the character.
    if (map[index] == null && !set.contains(string)) {
      map[index] = string;
      set.add(string);

    // Valid pattern match
    } else if (map[index] != null && map[index].equals(string)) {
      continue;
    } else {
      return false;
    }
  }

  return true;
}
