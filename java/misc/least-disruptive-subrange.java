public class Solution {
  public static int[] findLeastDisruptiveSubrange(int[] arr, int[] replace) {
    if (arr.length == 0 || replace.length == 0 || arr.length < replace.length) {
      return new int[2];
    }


    int minI = 0;
    int minJ = 0;
    int minDiff = Integer.MAX_VALUE;;
    for (int i = 0; i < arr.length - replace.length; i ++) {
      int cur = 0;
      for (int j = 0; j < replace.length; j ++) {
        cur += Math.abs(arr[i + j] - replace[j]);
      }

      if (cur < minDiff) {
        minI = i;
        minJ = i + replace.length - 1;
        minDiff = cur;
      }
    }

    return new int[] { minI, minJ };
  }
}
