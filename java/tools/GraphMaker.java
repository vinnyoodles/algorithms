package tools;

import java.util.HashSet;

public class GraphMaker {
    private final int EDGE_MAX = 64;
    public int[][] make(int n, int m) throws Exception {
        // A connected graph requires at least n - 1 edges.
        if (m < n - 1) {
            throw new Exception("Graph must have at least n - 1 edges");
        }

        // The graph has a max of (n(n - 1))/2 edges.
        if (m > (n * (n - 1)) / 2) {
            throw new Exception("Graph can have at most (n * (n - 1)) / 2 edges");
        }

        HashSet<String> visited = new HashSet<>();
        int[][] matrix = new int[n][n];

        // First, connect all the vertices to ensure a connected graph.
        for (int u = 1; u <= n - 1; u ++) {
            int v = u + 1;
            int w = 1 + (int) (Math.random() * EDGE_MAX);
            visited.add(u + "," + v);
            visited.add(v + "," + u);
            matrix[u - 1][v - 1] = w;
            matrix[v - 1][u - 1] = w;
            m --;
        }

        while (m > 0) {
            int u = getRandomVertex(n);
            int v = getRandomVertex(n);
            int w = 1 + (int) (Math.random() * EDGE_MAX);

            // Guarantee uniqueness
            while (u == v) {
                v = getRandomVertex(n);
            }

            String hashString = u + "," + v;
            String hashString2 = v + "," + u;
            if (visited.contains(hashString) || visited.contains(hashString2)) {
                continue;
            }

            visited.add(hashString);
            matrix[u][v] = w;
            matrix[v][u] = w;
            m --;
        }

        return matrix;
    }

    private int getRandomVertex(int n) {
        return (int) (Math.random() * n);
    }
}