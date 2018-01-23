package datastructures;

public class GraphEdge implements Comparable<GraphEdge> {
    int weight;
    int id1;
    int id2;

    public GraphEdge(int a, int b, int weight) {
        this.weight = weight;
        id1 = a;
        id2 = b;
    }

    public int getA() { return id1; }
    public int getB() { return id2; }

    public int compareTo(GraphEdge n) {
        return this.weight - n.weight;
    }
}