package datastructures;
public class GraphNode implements Comparable<GraphNode> {
    int weight;
    int id;
    public GraphNode(int i, int w) {
        id = i;
        weight = w;
    }

    public int compareTo(GraphNode n) {
        return this.weight - n.weight;
    }

    public int index() {
        return id - 1;
    }
}