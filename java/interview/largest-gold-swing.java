/**
 * @Company Riot Games
 *
 * We hypothesize that higlight moments occurs when one teams earns signifcantly more gold in a time window than the opposing team.
 * The easiest way to capture this is to find the moment in the game where the largest gold swing occurs.
 *
 * A gold swing is defined as the rate as which the difference in gold changes betweeen the two teams.
 * For example, if you know that at time 0 both team 1 and team 2 have a gold value of 0, and at time 2, team 1 now has 50 gold and
 * team 2 has 70 gold, then the rate of gold change team 1 experiences between time 0 and 2 is
 * (50 - 0) / (2 - 0) = 25 gold per time unit and team 2 has 35 gold per time. Therefore the gold swing is abs(25 - 35) = 10.
 *
 * Assume that each team starts with 0 gold at time 0 and that at any given
 * time the gold for a team is equal to the last entry seen for that team.
 *
 * The input will be a 2d array where each value is the gold at that point in time for both teams.
 * [ timestamp, team 1, team 2 ]
 * Return the starting timestamp of when the largest gold swing occurs.
 * 
 * Problem Ex.
 *   Input: [
 *     [ 1, 20, 30 ],
 *     [ 2, 30, 40 ],
 *     [ 3, 50, 40 ],
 *     [ 4, 80, 70 ],
 *     [ 5, 100, 80],
 *   ]
 *   Output: 2 because from time 2 - 3, team 1 gets 20 gold and team 2 gets 0 gold which is a swing of 20.
 *
 * Note: the timestamps are given in chronological order.
 */
public int largestGoldSwing(int[][] timestamps) { }
