import algorithms.PrimMST;
import algorithms.KruskalMST;

import tools.GraphMaker;
import tools.Utilities;

public class MSTTest {
    private static GraphMaker graphMaker;
    private static PrimMST prim;
    private static KruskalMST kruskal;
    public static void main(String[] args) throws Exception {
        graphMaker = new GraphMaker();
        prim = new PrimMST();
        kruskal = new KruskalMST();
        testSimple();
    }

    private static void testSimple() throws Exception {
        int[][] matrix = new int[][] {
            { 0,  7,  9,  0,  0, 14 },
            { 7,  0,  10, 15, 0, 0 },
            { 9,  10, 0,  11, 0, 2 },
            { 0,  15, 11, 0,  6, 0 },
            { 0,  0,  0,  6,  0, 9 },
            { 14, 0,  2,  0,  9, 0 }
        };

        int[][] mst = new int[][] {
            { 0, 1, 1, 0, 0, 0 },
            { 1, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 1, 0, 1 },
            { 0, 0, 1, 0, 1, 0 }
        };

        Utilities.compare(mst, prim.findMST(matrix));
        // Utilities.compare(mst, kruskal.findMST(matrix));

        matrix = new int[][] {
            { 0, 1, 3, 4 },
            { 1, 0, 2, 0 },
            { 3, 2, 0, 5 },
            { 4, 0, 5, 0 }
        };

        mst = new int[][] {
            { 0, 1, 0, 1 },
            { 1, 0, 1, 0 },
            { 0, 1, 0, 0 },
            { 1, 0, 0, 0 }
        };

        Utilities.compare(mst, prim.findMST(matrix));
        // Utilities.compare(mst, kruskal.findMST(matrix));

        matrix = new int[][] {
            { 0, 5,  0, 9,  1 },
            { 5, 0,  3, 14, 2 },
            { 0, 3,  0, 4,  7 },
            { 9, 14, 4, 0,  0 },
            { 1, 2,  7, 0,  0 }
        };

        mst = new int[][] {
            { 0, 0, 0, 0, 1 },
            { 0, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 0 },
            { 1, 1, 0, 0, 0 }
        };

        Utilities.compare(mst, prim.findMST(matrix));
        // Utilities.compare(mst, kruskal.findMST(matrix));
    }
}