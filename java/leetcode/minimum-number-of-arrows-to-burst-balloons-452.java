public int findMinArrowShots(int[][] points) {
  if (points.length <= 1) {
    return points.length;
  }

  // Sort the list so that we can take a greedy approach.
  Arrays.sort(points, (a, b) -> a[1] - b[1]);

  // Keep track of the number of arrows.
  int count = 0;

  // The index of where the last arrow was shot.
  int index = 0;
  for (int i = 0; i < points.lenght; i ++) {
    // If the current point starts past the current index.
    // Then, we must shoot another arrow to hit the current balloon.
    if (points[i][0] > index) {
      count ++;
      index = points[i][1];
    }
  }

  return count;
}
