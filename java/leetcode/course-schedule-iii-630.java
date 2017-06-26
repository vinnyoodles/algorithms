public class Solution {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);
    int time = 0;
    int count = 0;
    for (int i = 0; i < courses.length; i++) {

      // If possible to add the time, then add it.
      if (time + courses[i][0] <= courses[i][1]) {
        time += courses[i][0];
        courses[count++] = courses[i];
        continue;
      }

      // Not possible to add the current time.
      int max = i;

      // Iterate through all the past courses to find the max course duration
      // out of the possible courses.
      for (int j = 0; j < count; j++)
        if (courses[j][0] > courses[max][0]) max = j;

      // If the max value has changed, then update the time to be the difference of the old max and the new max.
      // In other words, remove the biggest course from the schedule and update the time.
      if (courses[max][0] != courses[i][0]) {
        time += courses[i][0] - courses[max][0];
        courses[max] = courses[i];
      }
    }

    return count;
  }

  // Recursive implementation
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);
    return helper(courses, 0, 0, 0);
  }

  public int helper(int[][] courses, int cur, int i, int day) {
    if (i >= courses.length) return cur;

    int without = helper(courses, cur, i + 1, day);
    int with = 0;
    if (courses[i][0] + day <= courses[i][1]) 
      with = helper(courses, cur + 1, i + 1, day + courses[i][0]);

    return Math.max(with, without);
  }
}
