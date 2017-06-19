/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 *
 * Solution:
 * For every number in nums1, we will call it num for simplicity, find the next greater element in nums2 by traversing from the back.
 * We iterate from the back because as soon as we find num, we break since we only want the next element AKA the element to the right.
 * Keep a variable that tracks the greatest element and initialize it to -1 so we do not have to check if one was found or not.
 * Because we iterate from the back, we never have to find the index of num in nums2 since that is when we break the loop.
 *
 * Complexity: O(n * m) time and O(n) space 
 * where n is the length of nums1 and m is the length of nums2
 *
 */
public class Solution {
  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    int[] res = new int[findNums.length];

    for (int i = 0; i < findNums.length; i ++) {
      int num = findNums[i];
      int greater = -1;

      // Iterate from back.
      for (int j = nums.length - 1; j >= 0; j --) {

        // Case where we found num in nums2.
        if (nums[j] == num) break;

        // Case where we update greater.
        // NOTE: we do not care what the previous value of greater is
        // since we only want a value that is greater than num and not the absolute maximum.
        if (nums[j] > num) greater = nums[j];
      }
      res[i] = greater;
    }

    return res;
  }
}
