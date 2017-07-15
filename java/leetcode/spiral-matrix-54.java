/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Input
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output : [1,2,3,6,9,8,7,4,5]
 * Note for this problem make sure you don't repeat elements. That was the issue that took me a while to figure out
 * Complexity : O(N^2) time , O(m * n) space
 */
public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<Integer>();
    int rowStart = 0;
    int rowEnd = matrix.length - 1;
    if (matrix.length == 0) return list;
    int colEnd = matrix[0].length - 1;
    int colStart = 0;

    while (rowStart <= rowEnd && colStart <= colEnd) {
      //left to right
      for (int i = colStart; i <= colEnd; i++) {
          System.out.println(matrix[rowStart][i]);
          list.add(matrix[rowStart][i]);
      }
      rowStart++;
      //right to down
      for (int i = rowStart; i <= rowEnd; i++) {
          list.add(matrix[i][colEnd]);
      }
      colEnd--;
      //right to left
      if (rowStart <= rowEnd) {
          for (int i = colEnd; i >= colStart; i--) {
              list.add(matrix[rowEnd][i]);
          }
      }
      rowEnd--;
      //down to top
      if (colStart <= colEnd) {
          for (int i = rowEnd; i >= rowStart; i--) {
              list.add(matrix[i][colStart]);
          }
      }
      colStart++;
    }
    return list;
  }
}
