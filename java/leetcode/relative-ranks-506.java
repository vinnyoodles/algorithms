/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores
 * so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Key: sort the poings from highest points to lowest points to give them their rankings.
 * Complexity : O(N) time , O(N) space
 */
 public class Solution {
  public String[] findRelativeRanks(int[] nums) {
    String[] res = new String[nums.length];
    Integer[] ranking = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ranking[i] = i;
    }
    Arrays.sort(ranking, (a, b) -> (nums[b] - nums[a]));

    for (int i = 0; i < ranking.length; i++) {
      // check the rankings and give the top there medals.
      if (i == 0) {
        res[ranking[i]] = "Gold Medal";
      } else if (i == 1) {
        res[ranking[i]] = "Silver Medal";
      } else if (i == 2) {
        res[ranking[i]] = "Bronze Medal";
      } else {
        res[ranking[i]] = (i + 1) + ""; // Convert int to string.
      }
    }
    return res;
  }
}
