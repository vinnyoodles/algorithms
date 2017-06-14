/**
 * Given a circular array (the next element of the last element is the first element of the array), 
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the 
 * first greater number to its traversing-order next in the array, which means you could search 
 * circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 */
public class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int[] arr = new int[nums.length];

    // Iterate through to find each greater element.
    for (int i = 0; i < arr.length; i ++) {
      int j = i + 1;
      int val = -1;

      // For every element find the closest greater element from the front.
      while (j != i) {
        // For circular arrays.
        if (j >= arr.length) j = 0;
        // If a cycle has been completed then break.
        if (j == i) break;
        // The greater element has been found.
        if (nums[j] > nums[i]) {
          val = nums[j];
          break;
        }

        j ++;
      }
      arr[i] = val;
    }

    return arr;
  }
}
