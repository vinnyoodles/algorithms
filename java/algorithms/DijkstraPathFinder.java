package algorithms;
import datastructures.PriorityQueue;

public class DijkstraPathFinder {
    private class Node implements Comparable<Node> {
        int weight;
        int id;
        public Node(int i, int w) {
            id = i;
            weight = w;
        }

        public int compareTo(Node n) {
            return this.weight - n.weight;
        }

        public int index() {
            return id - 1;
        }
    }

    public int[] find(int[][] matrix, int start) {
        int length = matrix.length;
        int[] dist = new int[length];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i ++) {
            // Every node but the source has an initial distance of infinity.
            dist[i] = (i + 1) == start ? 0 : Integer.MAX_VALUE;
        }

        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int[] neighbors = matrix[curr.index()];
            visited[curr.index()] = true;

            for (int i = 0; i < neighbors.length; i ++) {
                // Skip self node or non connected node.
                if (i == curr.index() || neighbors[i] == 0) continue;

                dist[i] = Math.min(dist[i], dist[curr.index()] + neighbors[i]);
                if (!visited[i]) {
                    queue.add(new Node(i + 1, dist[i]));
                }
            }
        }
        return dist;
    }
}