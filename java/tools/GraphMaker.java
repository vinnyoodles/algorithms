package tools;

import java.util.*;
import java.io.*;

/**
 * Creates a text file containing instructions to create a simple, undirected graph.
 * The file will be in the following format:
 * The first line of input will contain two space-separated integers: N and M.
 * Here, N is the number of vertices in the input graph and M is the number of edges. 
 * The vertices of the graph will be numbered 1 to N.
 * After the first line, M lines of input follow. Each of these M lines contains three space-separated integers,
 * 1 <= u, v, w <= N. Each such line indicates that there is an edge between the vertex u and the vertex v. 
 * w denotes the weight of the edge.
 * The graph will be simple, undirected and connected: each edge will be between a unique pair of vertices.
 */
public class GraphMaker {
    private final int EDGE_MAX = 64;
    public void make(String filename, int n, int m) throws Exception {
        // A connected graph requires at least n - 1 edges.
        if (m < n - 1) {
            throw new Exception("Graph must have at least n - 1 edges");
        }

        // The graph has a max of (n(n - 1))/2 edges.
        if (m > (n * (n - 1)) / 2) {
            throw new Exception("Graph can have at most (n * (n - 1)) / 2 edges");
        }

        FileWriter writer = new FileWriter(filename);
        Set<String> visited = new HashSet<>();
        writer.append(n + " " + m + "\n");

        // First, connect all the vertices to ensure a connected graph.

        for (int u = 1; u <= n - 1; u ++) {
            int v = u + 1;
            int w = (int) (Math.random() * EDGE_MAX);
            visited.add(u + "," + v);
            writer.append(u + " " + v + " " + w + "\n");
            m --;
        }

        while (m > 0) {
            int u = getRandomVertex(n);
            int v = getRandomVertex(n);
            int w = (int) (Math.random() * EDGE_MAX);

            // Guarantee uniqueness
            while (u == v) {
                v = getRandomVertex(n);
            }

            String hashString = u + "," + v;
            if (visited.contains(hashString)) {
                continue;
            }

            visited.add(hashString);
            writer.append(u + " " + v + " " + w + "\n");
            m --;
        }
        writer.close();
    }

    public void delete(String filename) {
        File file = new File(filename);
        file.delete();
    }

    private int getRandomVertex(int n) {
        return (int) (Math.random() * n);
    }
}