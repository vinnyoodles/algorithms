package algorithms;

import java.util.*;
import datastructures.GraphEdge;
import datastructures.DisjointSet;

public class KruskalMST {
    public int[][] findMST(int[][] matrix) throws Exception {
        int length = matrix.length;
        int[][] mst = new int[length][length];
        // Edges to be sorted.
        List<GraphEdge> edges = new ArrayList<>();

        // DisjointSet of nodes.
        DisjointSet set = new DisjointSet(length);

        for (int i = 0; i < length; i ++) {
            for (int j = i + 1; j < length; j ++) {
                if (matrix[i][j] > 0)  {
                    edges.add(new GraphEdge(i + 1, j + 1, matrix[i][j]));
                }
            }
        }

        if (edges.size() < length) throw new Exception("Not enough edges");

        // Sort edges by weight.
        Collections.sort(edges);

        int nodeCount = length;
        int edgeIndex = 0;
        while (nodeCount > 1) {
            GraphEdge edge = edges.get(edgeIndex++);
            int node1 = edge.getA();
            int node2 = edge.getB();
            if (set.find(node1) != set.find(node2)) {
                mst[node1 - 1][node2 - 1] = 1;
                mst[node2 - 1][node1 - 1] = 1;
                nodeCount --;
                set.union(node1, node2);
            }
        }

        return mst;
    }
}