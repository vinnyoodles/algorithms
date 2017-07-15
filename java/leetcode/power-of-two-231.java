/**
 * Given an integer, write a function to determine if it is a power of two.
 * Cute problem to do.
 * Complexity : O(1) time , O(1) space
 */
public class Solution {
  public boolean isPowerOfTwo(int n) {
    return n > 0 && Integer.bitCount(n) == 1;
  }
}
