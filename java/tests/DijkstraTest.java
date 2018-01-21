import algorithms.DijkstraPathFinder;
import tools.GraphMaker;

public class DijkstraTest {
    private static GraphMaker graphMaker;
    private static String filename = "input.in";
    public static void main(String[] args) throws Exception {
        graphMaker = new GraphMaker();
        testSimple();
    }

    // Test with a simple graph of 10 nodes and 20 edges.
    private static void testSimple() throws Exception {
        graphMaker.make(filename, 10 /*nodes*/, 20 /*edges*/);
    }
}