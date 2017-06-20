/**
 * @Company Riot Games
 *
 * Given a list of kill events where a kill event is defined as [ timestamp, killerId, victimId ].
 * Return a list of the users who have the largest killstreak. A killstreak is defined as a sequence 
 * of kills where each kill is no more than 15 units of time from the next kill.
 *
 * If there is a tie of users with the largest killstreak, then return an array of them.
 * The return format should be a list of all the users with the largest killstreak in the format of an array.
 * [ killerId, number of kills ]
 *
 * Problem Ex.
 *   Input: [
 *     [ 1, 1, 2 ],
 *     [ 5, 1, 3 ],
 *     [ 3, 1, 4 ],
 *     [ 9, 2, 1 ],
 *   ]
 *   Output: [ 
 *     [ 1, 3 ] 
 *   ]
 *
 * Note: the list of kills are not in any specific order.
 */
public int[][] largestKillstreak(int[][] kills) { }

/**
 * Part 2 expands on the definition of killstreak.
 * Killstreak is now defined as a sequence of kills where each kill is no more than 15 units of time from the next
 * as well as not dying from the beginning of the sequence to the end of the sequence.
 * 
 * This is more commonly the actual definition of a multi killstreak found in games.
 */
public int[][] largestKillstreak(int[][] kills) { }