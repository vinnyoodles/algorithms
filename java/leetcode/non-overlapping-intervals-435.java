/**
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public int eraseOverlapIntervals(Interval[] intervals) {
  if (intervals.length == 0) {
    return 0;
  }
  // Sort by the end interval.
  Arrays.sort(intervls, (a, b) -> a.end - b.end);
  int count = 0;

  // This pointer represents the current ending index of the current interval.
  int index = intervals[0].end;
  for (int i = 1; i < intervals.length; i ++) {

    // If the current interval's start index is greater than the ending index,
    // then we can update the ending index to be the current end because
    // these two are not overlapping.
    if (intervals[i].start >= index) {
      cur = temp.end;
    } else {
    // Otherwise, the two intervals are intersecting. Therefore, update the counter
    // and take the smallest end index between the two in order to minimize the number
    // of overlapping intervals.
      count ++;
      cur = Math.min(cur, intervals[i].end;
    }
  }

  return count;
}
