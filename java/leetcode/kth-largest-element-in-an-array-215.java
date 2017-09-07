public int findKthLargest(int[] nums, int k) {
  // Make k 0 indexed.
  k --;
  if (k < 0 || k > nums.length) {
    return -1;
  }
  Arrays.sort(nums);
  return nums[nums.length - 1 - k];
}
