/**
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to make it run in O(N^2) time.
        Arrays.sort(nums);

        // No index out of bounds error due to a guaranteed sum.
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i ++) {
            int currentTarget = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            // Find the target relative to index i.
            while (j < k) {
                int currentSum = nums[j] + nums[k];

                // If the sum is actually found, then just return this as it is as close as can be.
                if (currentSum == currentTarget) return target;

                // Update the closest sum to whichever is closer.
                int prevDiff = Math.abs(closestSum - target);
                int currDiff = Math.abs(currentSum + nums[i] - target);
                closestSum = prevDiff > currDiff ? currentSum + nums[i] : closestSum;
                if (currentSum > currentTarget) {
                    k --;
                } else {
                    j ++;
                }

            }
        }

        return closestSum;
    }
}
