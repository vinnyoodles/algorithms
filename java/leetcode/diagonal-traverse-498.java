public static int[] diagonalTraverse(int[][] grid) {
  if (grid.length == 0 || grid[0].length == 0) {
    return new int[0];
  }
  int count = grid.length * grid[0].length;
  int cur = 0;
  int col = 0;
  int[] arr = new int[count];
  boolean dir = false;
  while (cur < count) {
    int i = dir ? 0 : col;
    int j = dir ? col : 0;

    if (dir) {
      // Traverse diagonally upwards
      while (j >= 0 || i < grid.length) {
        if (isValid(grid, i, j)) {
          arr[cur ++] = grid[i][j];
        }
        i ++;
        j --;
      }
    } else {
      // Traverse diagonally downwards
      while (i >= 0 && j < grid[0].length) {
        if (isValid(grid, i, j)) {
          arr[cur ++] = grid[i][j];
        }
        i --;
        j ++;
      }
    }

    dir = !dir;
    col ++;
  }

  return arr;
}

public static boolean isValid(int[][] grid, int i, int j) {
  return i < grid.length && j < grid[0].length && i >= 0 && j >= 0;
}
