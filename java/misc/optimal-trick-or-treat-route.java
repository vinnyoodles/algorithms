/**
 * You and your friends are going trick-or-treating. Like everyone else, you want to
 * get as much candy as possible. Like a true engineer, you want to optimize the route so that you
 * don't have to walk too much.
 *
 * However, your mom said you can only hit one house per row so that you don't get kidnapped or worse, lost.
 * To save yourself from walking too much, you are limited to choosing the house directly below it or the house
 * at the exact diagonal to it.
 *
 * So if your neighborhood looked something like this:
 * [
 *   [ a, b, c, d ],
 *   [ e, f, g, h ],
 *   [ i, j, k, l ],
 * ]
 * From house a, the next possible houses are either e or f.
 * From house b, the next possible houses are e, f or g.
 * From house c, the next possible houses are f, g or h.
 * From house d, the next possible houses are g or h.
 * From house g, the next possible houses are j, k or l.
 *
 * Once you have reached the last row of houses, then you're done and head home.
 *
 * Given a matrix of houses and how much candy you can get at each house, find the maximum amount of candy you can
 * get while following the rules above.
 *
 * Example:
 * Input: [
 *   [ 3, 2, 4, 1 ],
 *   [ 5, 1, 6, 3 ],
 *   [ 1, 8, 2, 4 ],
 *   [ 2, 3, 1, 6 ]
 * ]
 *
 * The maximum amount of candy you can get is 21 from the route 4 -> 6 -> 8 -> 3.
 */
public int optimalRoute(int[][] houses) {
    int rows = houses.length;
    if ( rows == 0) {
      return 0;
    }
    if ( rows == 1) {
      return maxCandy(dp[rows]);
    }
    int cols = houses[0].length;
    int[][] dp = new int[rows][cols];
    for ( int i = 0; i < col; i++) { // copy the first row
      dp[0][i] = houses[0][i];
    }
    helper(houses, dp, rows, cols)
    return maxCandy(dp[rows - 1]); // max candy
}

private void helper(int[]][] houses, int[][] dp, int rows, int cols) {
    // we are going to add dp[]
    // making sure we can go can access all of the row and not get out of bounds
  for (int i = 0; i < rows - 1; i++) {
    for (int j = 0; j < cols; j++) {
    if (j > 1 && j < cols) {
      int left = houses[i][j] + houses[i][j - 1];
      int down = houses[i][j] + houses[i + 1][j];
      int right = houses[i1][j] + houses[i + 1][j + 1];
      int maxLeft = Math.max(left, dp[i + 1][j - 1]);
      int maxDown = Math.max(down, dp[i + 2][j]);
      int maxRight = Math.max(right, dp[i + 2][ j + 1]);
      dp[i + 1][j - 1] = maxLeft;
      dp[i + 2][j] = maxDown;
      dp[i + 2][j + 1] = maxRight;

    } else if ( j + 1 > cols && j - 1 > 0){ // when we can only go down and left
      // we have to get the max and then populate the dp array.
      int left = houses[i][j] + houses[i][j - 1];
      int down = houses[i][j] + houses[i + 1][j];
      int maxLeft = Math.max(left, dp[i + 1][j - 1]);
      int maxDown = Math.max(down, dp[i + 2][j]);
      dp[i + 1][j - 1] = maxLeft;
      dp[i + 2][j] = maxDown;

    } else if ( j - 1 < 0 && j + 1 < cols) { // when we can go right and down
      // since nothing is populated yet we don't have to worry about the only storing the max value
      dp[i + 2][j] = houses[i][j] + houses[i + 1][j]; // when we only go down
      dp[i + 2][j + 1]  = houses[i][j] + houses[i + 1][j + 1]; // we are looking at the right side.
    }
   }
   for ( int index = 0; index < cols; index++) { // copy the values to our array so we can compute the correct sum
     houses[i + 1][index] = dp[i + 2][index];
   }
  }
}

  private int maxCandy(int[] lastRow) {
    int max = Integer.MIN_VALUE;
    for ( int i = 0; i < lastRow.length; i++) {
      max = Math.max(max, lastRow[i]);
    }
    return max;
  }
}
