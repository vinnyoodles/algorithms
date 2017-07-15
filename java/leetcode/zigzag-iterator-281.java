/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * Input
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * Output
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * Complexity : O(N) time, O(m + n) m and n are the two list sizes : space
 */
public class ZigzagIterator {
  LinkedList<Iterator> list;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    list = new LinkedList();
    if (!v1.isEmpty()) {
      list.add(v1.iterator());
    }
    if (!v2.isEmpty()){
      list.add(v2.iterator());
    }
  }
  public int next() {
    Iterator it = list.remove();
    int res = (int)it.next();
    if (it.hasNext()) {
      list.add(it);
    }
    return res;
  }
  public boolean hasNext() {
    return !list.isEmpty();
  }
}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
