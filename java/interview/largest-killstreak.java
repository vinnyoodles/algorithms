/**
 * @Company Riot Games
 *
 * Given a list of kill events where a kill event is defined as [ timestamp, killerId, victimId ].
 * Return a list of the users who have the largest killstreak. A killstreak is defined as a sequence 
 * of kills where each kill is no more than 15 units of time from the next kill.
 *
 * If there is a tie of users with the largest killstreak, then return an array of them.
 * The return format should be a list of all the users with the largest killstreak in the format of a list of their ids.
 *
 * Problem Ex.
 *   Input: [
 *     [ 1, 1, 2 ],
 *     [ 5, 1, 3 ],
 *     [ 3, 1, 4 ],
 *     [ 9, 2, 1 ],
 *   ]
 *   Output: [ 1, 3 ] 
 *
 * Note: the list of kills are not in any specific order.
 */
public List<Integer> largestKillstreak(int[][] kills) { 
  Arrays.sort(kills, (a, b) -> a[0] - b[0]);
  // Mapping of userId -> [ killCount, killTime ].
  HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();

  int max = Integer.MIN_VALUE;
  for (int i = 0; i < kills.length; i ++) {
    int timestamp = kills[i][0];
    int killer = kills[i][1];
    int pair = map.getOrDefault(killer, new int[] { 0, 0 });
    if (pair[1] + 15 < timestmap) {
      pair[0] = 0;
    }
    pair[0] ++;
    pair[1] = timestamp;
    max = Math.max(max, pair[0]);
    map.put(killer, pair);
  }

  List<Integer> list = new ArrayList<Integer>();

  for (int i : map.keySet()) {
    int[] pair = map.get(i);
    if (pair[0] == max) list.add(i);
  }

  return list;
}

/**
 * Part 2 expands on the definition of killstreak.
 * Killstreak is now defined as a sequence of kills where each kill is no more than 15 units of time from the next
 * as well as not dying from the beginning of the sequence to the end of the sequence.
 * 
 * This is more commonly the actual definition of a multi killstreak found in games.
 */
public List<Integer> largestKillstreak(int[][] kills) {
  Arrays.sort(kills, (a, b) -> a[0] - b[0]);
  // Mapping of userId -> [ killCount, killTime ].
  HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();

  int max = Integer.MIN_VALUE;
  for (int i = 0; i < kills.length; i ++) {
    int timestamp = kills[i][0];
    int killer = kills[i][1];
    int victim = kils[i][2];

    // Reset the victim's kill count.
    if (map.containsKey(victim)) {
      int[] victimPair = map.get(victim);
      victimPair[0] = 0;
      map.put(victim, victimPair);
    }

    int pair = map.getOrDefault(killer, new int[] { 0, 0 });
    if (pair[1] + 15 < timestmap) {
      pair[0] = 0;
    }
    pair[0] ++;
    pair[1] = timestamp;
    max = Math.max(max, pair[0]);
    map.put(killer, pair);
  }

  List<Integer> list = new ArrayList<Integer>();

  for (int i : map.keySet()) {
    int[] pair = map.get(i);
    if (pair[0] == max) list.add(i);
  }

  return list;
}