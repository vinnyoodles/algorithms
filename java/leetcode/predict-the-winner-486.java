/**
 * Given an array of scores that are non-negative integers. 
 * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. 
 * Each time a player picks a number, that number will not be available for the next player. 
 * This continues until all the scores have been chosen. 
 * The player with the maximum score wins.
 * Given an array of scores, predict whether player 1 is the winner. 
 * You can assume each player plays to maximize his score.
 */
public class Solution {
  public boolean PredictTheWinner(int[] nums) {
    if (nums.length <= 2) return true;
    return predict(nums, 0, nums.length - 1, 0, 0, true /* player 1 goes first */);
  }

  public boolean predict(int[] nums, int i, int j, int p1, int p2, boolean turn) {
    if (i > j) {
      // Return true if the player that made the last move has won.
      // If p1 made the last move, then p1 >= p2.
      // If p2 made the last move, then p1 < p2.
      return turn ? p1 >= p2 : p2 > p1;
    }      

    if (turn) {
      return !predict(nums, i + 1, j,     p1 + nums[i], p2, !turn) ||
             !predict(nums, i,     j - 1, p1 + nums[j], p2, !turn);  
    } else {
      return !predict(nums, i + 1, j,     p1, p2 + nums[i], !turn) || 
             !predict(nums, i,     j - 1, p1, p2 + nums[j], !turn);
    }
  }
}