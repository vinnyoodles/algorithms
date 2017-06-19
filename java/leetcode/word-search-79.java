/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 */
public class Solution {
  public boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0 || word.length() == 0) return false;

    char[] arr = word.toCharArray();    
    Stack<int[]> starting = new Stack<int[]>();
    int length = board.length;
    int width = board[0].length;

    // Add all the starting positions to the list of starting positions.
    for (int i = 0; i < length; i ++) {
      for (int j = 0; j < width; j ++) {
        if (board[i][j] == arr[0]) starting.push(new int[] { i, j });
      }
    }

    while (!starting.isEmpty()) {
      int[] coor = starting.pop();
      if (findWord(board, arr, coor[0], coor[1], 0 /* starting index */)) return true;
    }

    return false;
  }

  private boolean findWord(char[][] board, char[] word, int x, int y, int charIndex) {
    if (charIndex >= word.length || x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;

    char current = board[x][y];
    if (current != word[charIndex]) return false;

    // Case where the word is found.
    if (charIndex == word.length - 1) return true;

    // Now try the possible word directions for the next character.
    char next = word[charIndex + 1];

    // up
    if (x > 0 && next == board[x - 1][y]) {
      board[x][y] = ' ';
      // Stop if already found
      if (findWord(board, word, x - 1, y, charIndex + 1)) return true;
      // Backtrack by adding back the current word.
      board[x][y] = current;
    }

    // left
    if (y > 0 && next == board[x][y - 1]) {
      board[x][y] = ' ';
      if (findWord(board, word, x, y - 1, charIndex + 1)) return true;
      board[x][y] = current;
    }

    // down
    if (x < board.length - 1 && next == board[x + 1][y]) {
      board[x][y] = ' ';
      if (findWord(board, word, x + 1, y, charIndex + 1)) return true;
      board[x][y] = current;
    }

    // right
    if (y < board[0].length - 1 && next == board[x][y + 1]) {
      board[x][y] = ' ';
      if (findWord(board, word, x, y + 1, charIndex + 1)) return true;
      board[x][y] = current;
    }

    return false;
  }
}