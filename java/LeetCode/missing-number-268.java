/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 *
 * The trick is to find the ideal sum if the missing number is included.
 * This can be found in constant time because if the array contains all numbers from 0 - n,
 * then the sum is just n * (n + 1) / 2.
 * The missing number is then just the difference between the ideal sum and the actual sum.
 */
public class Solution {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = ((n) * (n + 1))/ 2;
    int current = 0;
    for (int i : nums) current += i;
    return sum - current;
  }
}
