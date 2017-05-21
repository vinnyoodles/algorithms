import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<String> letterCombinations(String digits) {
    String[] map = new String[10];
    if (digits.length() == 0) return new ArrayList<String>();
    map[0] = "";
    map[1] = "";
    map[2] = "abc";
    map[3] = "def"; 
    map[4] = "ghi"; 
    map[5] = "jkl"; 
    map[6] = "mno"; 
    map[7] = "pqrs"; 
    map[8] = "tuv";
    map[9] = "wxyz";
    
    return permutation(digits, 0, map);
  }

  private List<String> permutation(String digits, int index, String[] map) {
    List<String> result;
    if (index < digits.length() - 1) {
      result = permutation(digits, index + 1, map);
    } else {
      result = new ArrayList<String>();
      result.add(new String(""));
    }

    List<String> newResult = new ArrayList<String>();
    for (int i = 0; i < result.size(); i ++) {
      String c = result.get(i);
      String mapped = map[digits.charAt(index) - '0'];

      for (int j = 0; j < mapped.length(); j ++) {
        newResult.add(mapped.charAt(j) + "" + c);
      }
    }

    return newResult;
  }
}