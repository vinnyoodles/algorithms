/**
 * @Company Riot Games
 * we hypothesize that higlight moments occurs when one teams earns signifcantly more gold in a time window than the opposing team.
 * The easiest way to capture this is to find the moment in the game where the largest gold swing occurs.
 *
 * A gold swing is defined as the rate as which the difference in gold changes betweeen the two teams.
 * For example, if you know that at time 0 both team 1 and team 2 have a gold value of 0, and at time 4, team 1 now has a 50 gold an
 * team 2 has 70 gold then the rate of gold change team 1 experiences between time 0 and 2 is
 *(50 - 0) / (2 - 0) = 25 gold per time and team 2 has 35 gold per time.
 *
 * Assume that each team starts at time 0 and 0 gold and that at any given
 * time the gold for a team is equal to the last entry seen for that team.
 *
 *  ts = timestamp, team1Gold = the current amount of team1 has, and team2Gold = the amout of gold team 2 has
 * Sample Input => format ts team1Gold team2Gold
 * 5
 * 1 20 30
 * 2 30 40
 * 3 50 40
 * 4 80 70
 * 5 100 80
 *
 * Output
 * 2 3 20.00
 * starting is 2 and ending at time 3 there was a 20 gold per second change between teams.
 */
public class Soultion {
    public static void main(String args[] ) throw Exception {

    }
}
