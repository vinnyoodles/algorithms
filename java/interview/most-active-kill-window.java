/**
 * @Company Riot Games
 *
 * Given a list of kills, return the start of the 30 second window that contains the most number of kills.
 * A kill is defined as an integer array of the format [ timestamp, killerId, victimId ].
 * If there is a tie, then return an array of all the windows.
 *
 * The return format should be a list of all the windows with the most number of kills in the format of an array.
 * [ timestamp of the start of the window, number of kills ]
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
 *   Output: [ 
 *     [ 1, 9 ] 
 *   ]
 *
 * Note: the list of kills are not in any specific order.
 */
public int[][] mostActiveKillWindow(int[][] kills) { }