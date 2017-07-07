
/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 */

public class Solution {
  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    Stack<int[]> stack = new Stack<int[]>();

    int count = 0;
    for (int i = 0; i < grid.length; i ++) {
      for (int j = 0; j < grid[0].length; j ++) {

        // Hit land which can be AT MOST 1 island.
        // Therefore increment by only 1 and convert all nearby land into water.
        if (grid[i][j] == '1') {
          count++;
          stack.clear();
          stack.push(new int[] { i, j });
          while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            int x = pair[0];
            int y = pair[1];
            if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == '0') continue;
            grid[x][y] = '0';
            stack.push(new int[] { x + 1, y });
            stack.push(new int[] { x - 1, y });
            stack.push(new int[] { x, y + 1 });
            stack.push(new int[] { x, y - 1 });

          }
        }
      }
    }
    return count;
  }
}