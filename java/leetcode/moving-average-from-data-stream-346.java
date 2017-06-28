/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * Input :  ["MovingAverage","next","next","next","next"]
 *          [[3],[1],[10],[3],[5]]
 *
 * Output : [null,1.00000,5.50000,4.66667,6.00000]
 * Complexity: O(1) time, space O(n) where is the given size of the array.
 */
public class MovingAverage {
  /** Initialize your data structure here. */
  int[] arr;
  int index;
  double res;
  int start;

  public MovingAverage(int size) {
    arr = new int[size];
    index = 0;
    res = 0;
    start = 0;
  }

  public double next(int val) {
    // keep a constant size to divide once we reach length - 1
    if (start < arr.length) {
      start++;
    }
    res -= arr[index];
    res += val;
    arr[index] = val;
    index = (index + 1) % arr.length;
    return res / start;
  }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
