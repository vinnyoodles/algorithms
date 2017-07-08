public int largestNest(int[] arr) {
  if (arr.length == 0) return 0;
  int max = 1;

  for (int i = 0; i < arr.length; i ++) {
    int j = arr[i];
    int count = 1;

    // Follow the cycle and mark each value as -1 (visited) so we dont repeat values.
    while (j >= 0 && j != i) {
      int temp = arr[j];
      arr[j] = -1;
      j = arr[j];
      count ++;
    }
    max = Math.max(max, count);
  }

  return max;
}