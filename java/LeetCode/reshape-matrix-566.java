/**
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Complexity: O(N * M) runtime and O(R * C) space where N and M are the length and height of the orignal array and R and C are the length and height of the new array.
 */
public class Solution {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    // No possible way to reshape.
    if (nums.length == 0 || nums[0].length == 0) return nums;
    if (r * c != nums.length * nums[0].length) return nums;

    int[][] arr = new int[r][c];
    int x = 0;
    int y = 0;

    for (int i = 0; i < r; i ++) {
      for (int j = 0; j < c; j ++) {
        arr[i][j] = nums[x][y];

        if (y < nums[0].length) y ++;

        if (y >= nums[0].length) {
          y = 0;
          x ++;
        }
      }
    }

    return arr;
  }
}
