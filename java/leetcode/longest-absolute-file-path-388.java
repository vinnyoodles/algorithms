/**
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 * For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext"
 * its length is 32 (not including the double quotes).
 *
 * Given a string representing the file system in the above format, return the length of the longest absolute path to
 * file in the abstracted file system. If there is no file in the system, return 0.
 *
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 * Complexity : O(N) time, O(N) space
 */
public class Solution {
  public int lengthLongestPath(String input) {
   int[] level = new int[input.length()];
   int max = 0;

   for (String s : input.split("\n")) {
     int depth = s.lastIndexOf("\t") + 1;
     // stores the depth as an index
     level[depth] = s.length() - depth + 1;
     if (depth - 1 >= 0) {
       level[depth] += level[depth - 1];
     }
     if (s.contains(".")) {
       max = Math.max(max, level[depth] - 1);
     }
   }
   return max;
  }
}
