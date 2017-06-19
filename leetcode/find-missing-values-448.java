/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * There is an O(N) space solution and an O(1) space solution.
 * Both run in O(N) time.
 */
public class Solution {

  // This is the O(N) space solution
  public List<Integer> findDisappearedNumbers(int[] nums) {
    // Use another array to keep track of what's been seen.
    int[] temp = new int[nums.length];
    for (int i = 0; i < nums.length; i ++) 
      temp[nums[i] - 1] ++;

    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i < temp.length; i ++) 

      // Any index that has a value greater than one means it has been seen.
      // The exact value shows how many hits it has received.
      if (temp[i] == 0) res.add(i +  1);

    return res;
  }

  // This is the O(1) space solution.
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 0; i < nums.length; i ++) {
      int index = Math.abs(nums[i]) - 1;
      // Only mark once as multiplying two negatives makes it positive,
      // therefore visiting an even number of times would make it seem unvisited.
      if (nums[index] > 0) 
        // Mark as visited by making it negative
        nums[index] = -1 * nums[index];
    }

    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i ++) {
      // Any non-negative means it has not been visited.
      if (nums[i] > 0) res.add(i +  1);
    }

    return res;
  }

  // Another version of the O(1) space solution
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> list = new ArrayList<Integer>();
    int current = 0;
    int goToIndex = 0;

    for(int i = 0; i < nums.length; i++) {
      current = Math.abs(nums[i]) - 1;
      goToIndex = Math.abs(nums[current]);
      nums[current] = goToIndex * -1;
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) 
        list.add(i + 1);
    }

    return list;
  }
}
