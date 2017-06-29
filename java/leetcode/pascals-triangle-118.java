/**
 * Generate and return the first n rows of pascal's triangle
 */
public class Solution {
  public List<List<Integer>> generate(int n) {
    List<List<Integer>> list = new ArrayList<List<Integer>>());
    triangle(n, 0, list);
    return list;
  }

  public void triangle(int n, int index, List<List<Integer>> list) {
    if (index == n) return;
    List<Integer> cur = new ArrayList<Integer>();
    cur.add(1);
    for (int i = 1; i < index; i ++) {
      List<Integer> above = list.get(index - 1);
      cur.add(above.get(i) + above.get(i - 1));
    }
    if (index > 0) cur.add(1);
    list.add(cur);
    triangle(n, index + 1, list);
  }
}