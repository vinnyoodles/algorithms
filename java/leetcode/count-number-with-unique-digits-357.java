/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 *
 * This is a simple counting problem and be solved using combinatorics.
 * For every additional digit, there is n - 1 remaining digits since one was just used.
 * Because there are only 10 total digits, all combinations where n > 10 is equal to n = 10.
 * The base case is where n = 0 and the answer is 1.
 */
public class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    if (n > 10) n = 10;
    if (n == 0) return 1;

    int[] dp = new int[n + 1];
    int sum = dp[0] = 1;

    for (int i = 1; i <= n; i ++) {
      if (i == 1) {
        dp[i] = sum = 9;
        continue;
      }

      int inverse = 10 - (i - 1);
      dp[i] = dp[i - 1] * inverse;
      sum += dp[i];
    }

    return sum;
  }
}