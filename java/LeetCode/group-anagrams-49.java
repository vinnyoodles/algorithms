public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();

    for (String s: strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String temp = new String(chars);
      if (map.containsKey(temp)) {
        List<String> list = map.get(temp);
        list.add(s);
        map.put(temp, list);
      } else {
        List<String> list = new ArrayList<String>();
        list.add(s);
        map.put(temp, list);
      }
    }

    List<List<String>> result = new ArrayList<List<String>>();

    for (String key: map.keySet()) {
      result.add(map.get(key));
    }

    return result;
  }
}
