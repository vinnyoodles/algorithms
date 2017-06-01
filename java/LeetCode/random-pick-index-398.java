// TODO: use reservoir sampling 
public class Solution {
  int[] nums;

  public Solution(int[] nums) {
    this.nums = nums;        
  }

  public int pick(int target) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0 ; i < nums.length; i ++ ) {
      if (this.nums[i] == target) {
        list.add(i);
      }
    }

    int length = list.size();
    int random = (int)(Math.random() * length);
    return list.get(random);
  }
}
