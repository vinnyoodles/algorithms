import algorithms.PrimMST;
import tools.GraphMaker;

public class PrimTest {
    public static void main(String[] args) throws Exception {
        GraphMaker graphMaker = new GraphMaker();
        graphMaker.make("input.in", 10, 11);
        graphMaker.delete("input.in");
    }
}