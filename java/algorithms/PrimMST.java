package algorithms;
import datastructures.PriorityQueue;
import datastructures.GraphEdge;

import tools.Utilities;

public class PrimMST {
    public int[][] findMST(int[][] matrix) throws Exception {
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[matrix.length];

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
                if (visited[i] || neighbors[i] == 0) continue;

                queue.add(new GraphEdge(node, i + 1, neighbors[i]));
            }

            GraphEdge minEdge = queue.poll();
            int neighbor = minEdge.adjacent(node);
            mst[neighbor - 1][node - 1] = 1;
            mst[node - 1][neighbor - 1] = 1;
            node = neighbor;
            count --;
        }

        return mst;
    }
}