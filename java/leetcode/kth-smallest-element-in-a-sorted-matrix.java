public int kthSmallest(int[][] grid, int k) {
  PriorityQueue<Integer> q = new PriorityQueue<>();
  for (int i = 0; i < grid.length; i ++) {
    for (int j = 0; j < grid[i].length; j ++) {
      q.add(grid[i][j]);
    }
  }

  // Subtract one from K to make it 0 indexed.
  k --;
  for (int i = 0; i < k; i ++) {
    q.poll();
  }

  return q.poll();
}
