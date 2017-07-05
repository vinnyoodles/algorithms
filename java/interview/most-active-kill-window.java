/**
 * @Company Riot Games
 *
 * Given a list of kills, return the start of the 30 second window that contains the most number of kills.
 * A kill is defined as an integer array of the format [ timestamp, killerId, victimId ].
 * If there is a tie, then return an array of all the windows.
 *
 * The return format should be a list of all the windows (their start time) with the most number of kills.
 *
 * Problem Ex.
 *   Input: [
 *     [ 1, 1, 2 ],
 *     [ 5, 1, 3 ],
 *     [ 15, 1, 5 ],
 *     [ 9, 2, 1 ],
 *     [ 11, 3, 1 ],
 *     [ 35, 5, 4 ],
 *     [ 15, 4, 3 ],
 *     [ 7, 4, 2 ],
 *     [ 31, 2, 1 ],
 *     [ 25, 6, 3 ],
 *   ]
 *   Output: [ 1, 5 ]
 *
 * Note: the list of kills are not in any specific order.
 *
 * Solution: O(N * logN) time and O(N) space.
 */

public static List<Integer> mostActiveKillWindow(int[][] kills) {
  // Sort by the timestamp.
  Arrays.sort(kills, (a, b) -> a[0] - b[0]);
  int windowSize = 30;

  // The last kill will be at the end now that it is sorted.
  int maxTime = kills[kills.length - 1][0];

  // Store the start time, end time, and the current kill count.
  int maxKill = Integer.MIN_VALUE;
  int[][] windows = new int[kills.length][3];

  for (int i = 0; i < kills.length; i ++) {
    int killTime = kills[i][0];
    // Populate the window sizes.
    windows[i][0] = kills[i][0];
    windows[i][1] = kills[i][0] + 30;
    // Update all the windows that this may fit in.
    for (int j = 0; j <= i; j ++) {
      int start = windows[j][0];
      int end = windows[j][1];

      if (killTime >= start && killTime <= end) {
        windows[j][2] ++;
      }

      // Keep track of the highest kill count.
      maxKill = Math.max(maxKill, windows[j][2]);
    }
  }

  // Add all the matching windows.
  List<Integer> res = new ArrayList<Integer>();
  for (int i = 0; i < kills.length; i ++) {
    if (windows[i][2] == maxKill) {
      res.add(windows[i][0]);
    }
  }

  return res;
}