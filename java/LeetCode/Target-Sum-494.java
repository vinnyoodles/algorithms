/*
 * Problem: You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * To approach this problem think of a recursion tree with different two different possibility where you can subtract or add
 * time Complexity of 2^n Solution.
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int S) {
         if (nums.length == 0){
            return 0;
        }
        int validCount = 0;
        return helper(nums, validCount, S, 0, 0 );

    }
    private int helper(int[] nums, int totalValidSum, int sumValue, int startIndex, int tempSum){
        if(startIndex == nums.length){
            // since we want all of the value then we check of valid sum
            if(tempSum == sumValue){
                totalValidSum++;
            }
          return totalValidSum;
        }
         return helper(nums, totalValidSum,sumValue, startIndex+1, tempSum+nums[startIndex]) +
         helper(nums, totalValidSum,sumValue, startIndex+1, tempSum-nums[startIndex]);

    }
}
