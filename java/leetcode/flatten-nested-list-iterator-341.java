/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

  Queue<Integer> q;
  public NestedIterator(List<NestedInteger> nestedList) {
    q = new LinkedList<>();
    append(nestedList);
  }

  private void append(List<NestedInteger> list) {
    for (NestedInteger cur : list) {
      if (cur.isInteger()) {
        q.add(cur.getInteger());
      } else {
        append(cur.getList());
      }
    }
  }

  public Integer next() {
    return q.poll();
  }

  public boolean hasNext() {
    return !q.isEmpty(); 
  }
}

