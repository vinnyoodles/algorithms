public class Solution {
  // O(n) soultion, n being the size timeSeries.
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (timeSeries.length == 0) {
      return 0;
    }
    int start = timeSeries[0];
    int total = 0;

    for (int i = 0; i < timeSeries.length; i++) {
      if (timeSeries[i] < duration + start) {
        total += timeSeries[i] - start;
      } else {
        total += duration;
      }
      start = timeSeries[i];
    }
    return total + duration;
  }
}
