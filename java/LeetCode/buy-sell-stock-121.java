public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length < 2) return 0;
    int max = 0;
    int s = 0;
    int e = 1;
    while (e < prices.length) {
      max = Math.max(max, prices[e] - prices[s]);
      if (prices[s] < prices[e]) {
        e ++;
      } else {
        s ++;
        e = s + 1;
      }

    }
    return max;
  }
}
