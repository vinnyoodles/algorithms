import java.util.concurrent.TimeUnit;
public class GameOfLife {
    public static void main(String[] args) throws Exception {
        Board board = new Board(10);
        board.flip(5, 5);
        board.flip(5, 4);
        board.flip(5, 6);
        board.flip(4, 6);
        board.flip(3, 5);
        board.run();
    }

    static class Board {
        boolean[][] board;
        boolean[][] next;
        int[][] neighbors;
        int size;
        final char ALIVE = '#';
        final char DEAD = '.';
        public Board(int n) {
            board = new boolean[n][n];
            next = new boolean[n][n];
            neighbors = new int[][] {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, -1},
                {0, 1},
                {1, -1},
                {1, 0},
                {1, 1}
            };
            size = n;
        }

        public void flip(int i, int j) {
            board[i][j] = !board[i][j];
        }

        public void run() throws Exception {
            while (true) {
                print();
                update();
                TimeUnit.SECONDS.sleep(1);
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }

        private void update() {
            for (int i = 0; i < size; i ++) {
                for (int j = 0; j < size; j ++) {
                    next[i][j] = updateCell(i, j);
                }
            }

            // Swap the two boards.
            boolean[][] temp = board;
            board = next;
            next = temp;
        }

        private boolean updateCell(int i, int j) {
            int live = 0;
            for (int[] n : neighbors) {
                int ni = i + n[0];
                int nj = j + n[1];
                if (ni < 0 || nj < 0 || nj >= size || ni >= size) continue;
                if (board[ni][nj])
                    live ++;
            }

            // Case 1: Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
            if (board[i][j] && live < 2) return false;
            // Case 2: Any live cell with two or three live neighbours lives on to the next generation.
            if (board[i][j] && live >= 2 && live <= 3) return true;
            // Case 3: Any live cell with more than three live neighbours dies, as if by overpopulation.
            if (board[i][j] && live > 3) return false;
            // Case 4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            if (!board[i][j] && live == 3) return true;

            // Continue with current state.
            return board[i][j];
        }

        private void print() {
            StringBuffer b = new StringBuffer();
            for (int i = 0; i < size; i ++) {
                for (int j = 0; j < size; j ++) {
                    char curr = board[i][j] ? ALIVE : DEAD;
                    b.append(curr);
                    if (j + 1 < size)
                        b.append(' ');
                }
                b.append('\n');
            }

            System.out.print(b.toString());
        }
    }
}
