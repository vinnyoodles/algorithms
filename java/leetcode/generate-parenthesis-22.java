/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<String>();
    helper(n, 0, 0, "", list);
    return list;
  }

  void helper(int n, int i, int j, String s, List<String> list) {
    if (i + j == 2 * n) {
      list.add(s);
      return; 
    }

    // First, add all the opening parenthesis.
    if (i < n) helper(n, i + 1, j, s + "(", list);

    // If there is an unmatched parenthesis, then add a matching closing one.
    if (j != i) helper(n, i, j + 1, s + ")", list);
  }
}