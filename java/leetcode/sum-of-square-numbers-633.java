/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Complexity : O(Sqrt(N)) time, O(Sqrt(N)) space
 */
 public class Solution {
  public boolean judgeSquareSum(int c) {
    if  (c <= 1) {
        return true;
    }
    Set<Integer> set = new HashSet<>();
    for (int a = 0; a < (int) Math.sqrt(c) + 1; a++) {
        int b = c - (a*a); // b^2 val;
        set.add(b);
    }
    // checking if the b^2 exits.
    for (int b = 0; b < (int) Math.sqrt(c) + 1; b++) {
        if (set.contains((b*b))) {
            return true;
        }
    }
    return false;
  }
}
