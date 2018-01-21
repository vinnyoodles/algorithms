import algorithms.DijkstraPathFinder;

import tools.GraphMaker;
import tools.Utilities;

import java.util.LinkedList;
import java.util.Queue;

public class DijkstraTest {
    private static GraphMaker graphMaker;
    private static String filename = "input.in";
    private static DijkstraPathFinder pathFinder;
    public static void main(String[] args) throws Exception {
        graphMaker = new GraphMaker();
        pathFinder = new DijkstraPathFinder();
        testSimple();
        for (int i = 0; i < 10; i ++) {
            testRandom();
        }
    }

    // Test with a simple graph of 5 nodes and 6 edges.
    private static void testSimple() throws Exception {
        int[][] matrix = new int[][] {
            { 0,  7,  9,  0,  0, 14 },
            { 7,  0,  10, 15, 0, 0 },
            { 9,  10, 0,  11, 0, 2 },
            { 0,  15, 11, 0,  6, 0 },
            { 0,  0,  0,  6,  0, 9 },
            { 14, 0,  2,  0,  9, 0 }
        };

        int[] expected = new int[] { 0, 7, 9, 20, 20, 11 };
        int[] actual = pathFinder.find(matrix, 1 /* first node */);
        int[] brute = bruteForceShortestPath(matrix, 1);
        Utilities.compare(expected, actual);
        Utilities.compare(expected, brute);

        matrix = new int[][] {
            { 0, 4,  0, 0,  0,  0,  0, 8,  0 },
            { 4, 0,  8, 0,  0,  0,  0, 11, 0 },
            { 0, 8,  0, 7,  0,  4,  0, 0,  2 },
            { 0, 0,  7, 0,  9,  14, 0, 0,  0 },
            { 0, 0,  0, 9,  0,  10, 0, 0,  0 },
            { 0, 0,  4, 14, 10, 0,  2, 0,  0 },
            { 0, 0,  0, 0,  0,  2,  0, 1,  6 },
            { 8, 11, 0, 0,  0,  0,  1, 0,  7 },
            { 0, 0,  2, 0,  0,  0,  6, 7,  0 }
        };

        expected = new int[] { 0, 4, 12, 19, 21, 11, 9, 8, 14 };
        actual = pathFinder.find(matrix, 1 /* first node */);
        brute = bruteForceShortestPath(matrix, 1);
        Utilities.compare(expected, actual);
        Utilities.compare(expected, brute);
    }

    private static void testRandom() throws Exception {
        int[] params = Utilities.getRandomGraphParameters();
        System.out.printf("\tGraph parametrs (n = %d, m = %d)\n", params[0], params[1]);
        int[][] matrix = graphMaker.make(params[0], params[1]);
        int[] brute = bruteForceShortestPath(matrix, 1);
        int[] dijkstra = pathFinder.find(matrix, 1);
        Utilities.compare(brute, dijkstra);
    }

    private static int[] bruteForceShortestPath(int[][] matrix, int start) {
        int[] dist = new int[matrix.length];
        boolean[] visited = new boolean[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            dist[i] = (i + 1) == start ? 0 : Integer.MAX_VALUE;
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int curr = -1;

            for (int v = 0; v < matrix.length; v++) {
                if (visited[v] == false && dist[v] <= min) {
                    min = dist[v];
                    curr = v;
                }
            }

            // Mark the picked vertex as visited.
            visited[curr] = true;

            // Update distance value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < matrix.length; v++) {
                if (v == curr || matrix[curr][v] == 0) {
                    continue;
                }

                dist[v] = Math.min(dist[v], dist[curr] + matrix[curr][v]);
            }
        }
        return dist;
    }
}