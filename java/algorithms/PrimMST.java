package algorithms;
import datastructures.PriorityQueue;
import datastructures.GraphEdge;

import tools.Utilities;

public class PrimMST {
    public int[][] findMST(int[][] matrix) {
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[matrix.length];
        boolean[][] inQueue = new boolean[matrix.length][matrix.length];

        // A tree with n nodes will have n - 1 edges.
        int count = matrix.length - 1;

        // Pick a random starting node.
        int node = Utilities.getRandomNumber(1, matrix.length + 1);

        // Resultant matrix.
        int[][] mst = new int[matrix.length][matrix.length];

        while (count > 0) {
            int[] neighbors = matrix[node - 1];
            visited[node - 1] = true;
            for (int i = 0; i < neighbors.length; i ++) {
                // Skip visited nodes and edges of 0 weight.
                if (i == node - 1 || inQueue[i][node - 1] || neighbors[i] == 0) continue;

                inQueue[i][node - 1] = true;
                inQueue[node - 1][i] = true;
                queue.add(new GraphEdge(node, i + 1, neighbors[i]));
            }

            GraphEdge minEdge = queue.poll();

            // If both nodes of the edge have been visited, then skip this edge.
            if (visited[minEdge.getA() - 1] && visited[minEdge.getB() - 1]) continue;
            mst[minEdge.getA() - 1][minEdge.getB() - 1] = 1;
            mst[minEdge.getB() - 1][minEdge.getA() - 1] = 1;

            // The next node will be the one that has not been visited yet.
            node = visited[minEdge.getA() - 1] ? minEdge.getB() : minEdge.getA();
            count --;
        }

        return mst;
    }
}