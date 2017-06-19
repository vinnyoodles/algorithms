function largestRegion(grid) {
  var score = 0;
  for (var row in grid) {
    for (var col in grid[row]) {
      if (grid[row][col] === 1) score = Math.max(score, findRegionSize(grid, row, col));
    }
  }

  return score;
}

function findRegionSize(grid, row, col) {
  row = Number(row);
  col = Number(col);
  if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) return 0;
  else if (grid[row][col] === 0) return 0;

  // Mark as visited by setting to 0.
  grid[row][col] = 0;
  var size = 1;

  for (var r = row - 1; r <= row + 1; r++) {
    for (var c = col - 1; c <= col + 1; c++) {
      if (r !== row || c !== col) size += findRegionSize(grid, r, c);
    }
  }

  return size;
}

module.exports = largestRegion;
