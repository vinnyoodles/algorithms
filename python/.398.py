class Solution(object):

    def __init__(self, nums):
        """

        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        # we go through all of the values in the array, as we are going we the values
        # if they equal. then we add them to the list. Then ouput the index randomly with
        # with equal probability 
        return random.choice([k for k, v in enumerate(self.nums) if v == target])


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
