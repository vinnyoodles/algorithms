import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphColoring {
  int numVertex;
  ArrayList<Integer> adj[];

  GraphColoring(int num) {
    adj = new ArrayList[num];
    this.numVertex = num;
  }

  void addEdge(int a, int b) {
    if (a == b) return;
    adj[a].add(b);
    adj[b].add(a);
  }

  int color() {
    int colors = new int[numVertex];

    return 1;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    GraphColoring graph = new GraphColoring(n);
    for (int i = 0; i < n; i++) {
      graph.adj[i] = new ArrayList<>();
      String line = s.nextLine();
      String[] tokens = line.split("\\s");
      for (String t: tokens) {
        graph.adj[i].add(Integer.parseInt(t));
      }
    }
    System.out.println(graph.color());

  }
}
