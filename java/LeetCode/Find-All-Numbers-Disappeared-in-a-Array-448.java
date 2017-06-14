/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Complexity: O(N) time , O(1) time. Trick to solving the problem is to use negative to mark the place you visisted
 * that way you can find the values that are positive and then you can add the index + 1 to the result list.
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int current = 0;
        int goToIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            current = Math.abs(nums[i])  - 1;
            // go to the current Index val in the array and change its value to negative;
            goToIndex = Math.abs(nums[current]);
            nums[current] = goToIndex * - 1;
        }
        for(int i = 0; i < nums.length; i++){
          if( nums[i] > 0 ) {
              list.add(i+1);
          }
        }
        return list;
    }
}
