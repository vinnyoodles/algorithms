/**
 * Given a list of building heights, return a subset of building that can view the westward sun.
 * All buildings only have windows facing the west.
 * Therefore, if a building west of another building is taller, then the second building cannot see the sun.
 * Ex. [1, 2, 3, 4] => [1, 2, 3, 4]
 *     [4, 3, 2, 1] => []
 *     [1, 3, 2, 5, 4, 7] => [1, 3, 5, 7]
 */
public List<Integer> buildings(int[] heights) {
  List<Integer> result = new ArrayList<Integer>();
  int index = 0;
  int currentMax = 0;

  while (index < heights.length) {
    if (heights[index] > currentMax) result.add(heights[index]);
    currentMax = Math.max(currentMax, heights[index]);
    index ++;
  }
  return result;
}
