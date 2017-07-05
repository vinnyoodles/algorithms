/**
 * You and your friends are going trick-or-treating. Like everyone else, you want to 
 * get as much candy as possible. Like a true engineer, you want to optimize the route so that you
 * don't have to walk too much.
 *
 * However, your mom said you can only hit one house per row so that you don't get kidnapped or worse, lost. 
 * To save yourself from walking too much, you are limited to choosing the house directly below it or the house 
 * at the exact diagonal to it.
 *
 * So if your neighborhood looked something like this:
 * [
 *   [ a, b, c, d ],
 *   [ e, f, g, h ],
 *   [ i, j, k, l ],
 * ]
 * From house a, the next possible houses are either e or f.
 * From house b, the next possible houses are e, f or g.
 * From house c, the next possible houses are f, g or h.
 * From house d, the next possible houses are g or h.
 * From house g, the next possible houses are j, k or l.
 *
 * Once you have reached the last row of houses, then you're done and head home.
 *
 * Given a matrix of houses and how much candy you can get at each house, find the maximum amount of candy you can
 * get while following the rules above.
 * 
 * Example:
 * Input: [
 *   [ 3, 2, 4, 1 ],
 *   [ 5, 1, 6, 3 ],
 *   [ 1, 8, 2, 4 ],
 *   [ 2, 3, 1, 6 ]
 * ]
 * 
 * The maximum amount of candy you can get is 21 from the route 4 -> 6 -> 8 -> 3.
 */
public int optimalRoute(int[][] houses) {}