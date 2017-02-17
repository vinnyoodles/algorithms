import java.util.Scanner;

public class NQueens {
  static Boolean[][] queens;
  static int[][] conflicts;
  static int N;
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    N = s.nextInt();
    queens = new Boolean[N][N];
    conflicts = new int[N][N];
    solve(0);
    print();
  }

  static void print() {
    for (int y = 0; y < N; y ++) {
      for (int x = 0; x < N; x ++) {
        try {
          if (queens[y][x]) {
            System.out.print("x");
          } else {
            System.out.print(".");
          }
        } catch (Exception e) {
          System.out.print(".");
        }
      }
      System.out.println("");
    }
  }

  static boolean solve(int row) {
    if (N == row) return true;

    for (int col = 0; col < N; col++) {
      if (conflicts[row][col] == 0) {
        addQueen(row, col);
        if (solve(row + 1)) {
          return true;
        }
        removeQueen(row, col);
      }
    }
    return false;
  }

  // Add a queen a (x, y) and mark all conflicting spots by incrememnting
  public static void addQueen(int row, int col) {
     queens[row][col] = true;

     for (int r = row+1; r < N; r++) {
         conflicts[r][col]++;
     }

     for (int d = 1; row+d < N && col+d < N; d++) {
         conflicts[row+d][col+d]++;
     }

     for (int d = 1; row+d < N && col-d >= 0; d++) {
         conflicts[row+d][col-d]++;
     }
  }

  public static void removeQueen(int row, int col) {
     queens[row][col] = false;

     for (int r = row+1; r < N; r++) {
         conflicts[r][col]--;
     }

     for (int d = 1; row+d < N && col+d < N; d++) {
         conflicts[row+d][col+d]--;
     }

     for (int d = 1; row+d < N && col-d >= 0; d++) {
         conflicts[row+d][col-d]--;
     }
  }
}
