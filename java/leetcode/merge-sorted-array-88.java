public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p = m + n - 1;
    int a = m - 1;
    int b = n - 1;
    while (p >= 0) {
      if (a == -1) {
        nums1[p] = nums2[b--];
      } else if (b == -1) {
        nums1[p] = nums1[a--];
      } else if (nums1[a] > nums2[b]) {
        nums1[p] = nums1[a--];
      } else if (nums1[a] < nums2[b]) {
        nums1[p] = nums2[b--];
      } else {
        nums1[p] = nums1[a--];
      }

      p --;
    }
  }
}
