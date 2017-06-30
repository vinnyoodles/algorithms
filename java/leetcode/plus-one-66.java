/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
  public int[] plusOne(int[] digits) {
    // Start as 1 so that we dont need to add extra code to truly add one.
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i --) {
      int cur = digits[i];
      int sum = carry + cur;
      if (sum > 9) {
        digits[i] = sum - 10;
        carry = 1;
      } else {
        digits[i] = sum;
        carry = 0;
      }

      if (carry == 0) break;
    }

    if (carry > 0) {
      int[] temp = new int[digits.length + 1];
      temp[0] = carry;
      for (int i = 0; i < digits.length; i ++)
        temp[i + 1] = digits[i];
      return temp;
    }

    return digits;
  }
}