/**
 * There are N students in a class. Some of them are friends, while some are not. 
 * Their friendship is transitive in nature. 
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. 
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
 * And you have to output the total number of friend circles among all the students.
 */
public int findCircleNum(int[][] friends) {
  /**
   * For every `1` seen, increment the count by 1 and then change all direct and indirect relationships to 0 
   * because they are all in the same friend group.
   * The runtime is N^2 and the space complexity is N where N is the number of friends.
   */

  int count = 0;
  Stack<Integer> stack = new Stack<Integer>();
  int[] visited = new int[friends.length];

  for (int i = 0; i < friends.length; i ++) {
    for (int j = 0; j < friends[i].length; j ++) {
      if (friends[i][j] == 1) {
        count ++;
        stack.clear();
        stack.push(i);
        stack.push(j);
        while (!stack.isEmpty()) {
          int index = stack.pop();
          // If out of bounds or if we have marked the entire row already.
          if (index < 0 || index >= friends.length || visited[index] == 1) continue;
          visited[index] = 1;
          for (int k = 0; k < friends[index].length; k ++) {
            if (friends[index][k] == 1) {
              friends[index][k] = 0;
              stack.push(k);
            }
          }
        }
      }
    }
  }

  return count;
}