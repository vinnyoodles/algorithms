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
    }
    public int[] find(int[][] matrix, int start) {
        int length = matrix.length;
        int[] dist = new int[length];
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < length; i ++) {
            // Every node but the source has an initial distance of infinity.
            dist[i] = (i + 1) == start ? 0 : Integer.MAX_VALUE;
            queue.add(new Node(i + 1, dist[i]));
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
        }
        return dist;
    }
}