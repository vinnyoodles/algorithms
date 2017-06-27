/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class Solution {
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] courses = new int[numCourses];
    for (int i = 0; i < numCourses; i ++) 
      courses[i] = i;

    return null != topologicalOrder(courses, prerequisites);
  }

  public static List<Integer> topologicalOrder(int[] courses, int[][] dep) {
    // map to represent the graph where the key is the node and the value is the list of adjacent nodes.
    HashMap<Integer, List<Integer>> table = new HashMap<Integer, List<Integer>>();
    // Hashset to keep track of duplicates.
    HashSet<Integer> visited = new HashSet<Integer>();

    // Populate the map with empty lists.
    for (int i = 0; i < courses.length; i ++)
      table.put(courses[i], new ArrayList<Integer>());

    // Iterate through the dependencies which are the edges where the second value is the start node and the first value is the end node.
    // For example, this dependency [A, B] is represented in the graph as node A points to node B.
    for (int i = 0; i < dep.length; i++) {
      List<Integer> list = table.get(dep[i][0]);
      list.add(dep[i][1]);
    }

    // the list to return.
    List<Integer> order = new ArrayList<Integer>();

    for (int i = 0; i < courses.length; i ++) {
      order = topologicalSort(table, visited, order, courses[i]);
      if (order == null) return null;
    }

    return order;
  }

  private static List<Integer> topologicalSort(HashMap<Integer, List<Integer>> table, HashSet<Integer> visited, List<Integer> order, int index) {
    // If the node is in the visited set then return to prevent duplicates.
    if (visited.contains(index)) return order;

    // Mark the node as visited.
    visited.add(index);

    // Iterate through and call recursively for every neighbor.
    List<Integer> neighbors = table.get(index);
    for (int i = 0; i < neighbors.size(); i ++) {
      // Prevent duplicates
      int neighbor = neighbors.get(i);
      if (visited.contains(neighbor)) {
        // If the neighbor has already been visited but is not in the final topological order, then a cycle must exist.
        if (!order.contains(neighbor)) return null;
        continue;
      }

      // Set order equal to the recursive call.
      order = topologicalSort(table, visited, order, neighbor);
      if (order == null) return null;
    }

    // Add to the order list then return it.
    order.add(index);
    return order;
  }
}
