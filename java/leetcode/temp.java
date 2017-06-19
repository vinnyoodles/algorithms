/**
 *Given a binary array, find the maximum number of consecutive 1s in this array.
 *Input: [1,1,0,1,1,1]
 *Output: 3
 *Complexity O(n) time , and O(1) space.
 *trick count the number of ones until you see a different number and record the Max value as you go along.
 *When you see if reset the count.
 */
public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int numOfOnes = 0;
    int numOfConsecutiveOnes = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 1) {
        numOfOnes = 0;
      } else {
        numOfOnes++;
      }
      numOfConsecutiveOnes = Math.max(numOfOnes, numOfConsecutiveOnes);
    }
    return numOfConsecutiveOnes;
  }
}
