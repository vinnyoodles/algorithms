/**
 * Given a grid (two dimensional array), return an array of its value in spiral order.
 *
 * @param  {Array<Array>} grid
 * @return {Array}
 */
function spiralGrid(grid) {
  if (!grid || !grid.length || !grid[0].length) return [];

  var maxY = grid.length;
  var maxX = grid[0].length;
  var minY = 0;
  var minX = 0;
  var array = [];
  var size = grid.length * grid[0].length;

  var x = 0;
  var y = 0;
  while(array.length < size) {
    for (x = minX; x < maxX; x++) {
      array.push(grid[y][x]);
    }
    if (array.length === size) return array;
    minY++;
    x--;

    for (y = minY; y < maxY; y++) {
      array.push(grid[y][x]);
    }
    if (array.length === size) return array;
    maxX--;
    y--;

    for (x = maxX - 1; x >= minX; x--) {
      array.push(grid[y][x]);
    }
    if (array.length === size) return array;
    maxY--;
    x++;

    for (y = maxY - 1; y >= minY; y--) {
      array.push(grid[y][x]);
    }
    if (array.length === size) return array;
    minX++;
    y++;
  }

  return array;
}

module.exports = spiralGrid;
