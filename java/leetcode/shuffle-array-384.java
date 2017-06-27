/**
 * Shuffle a set of numbers without duplicates.
 * @return the random shuffling of the given array.
*/
public class Solution {

    int[] original;
    public Solution(int[] nums) {
      this.original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
      return this.original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      int[] clone = new int[original.length];
      for (int i = 0; i < clone.length; i ++) {
        clone[i] = original[i];
      }
      int[] arr = new int[clone.length];
      int len = clone.length;

      for (int i = 0; i < clone.length; i ++) {
        int index = (int)(Math.random() * (len--));
        arr[i] = clone[index];
        clone[index] = clone[len];
      }

      return arr;
    }
  }
}
