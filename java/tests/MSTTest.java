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
        for (int i = 0; i < 10; i ++)
            testCompare();
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
        Utilities.compare(mst, kruskal.findMST(matrix));

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
        Utilities.compare(mst, kruskal.findMST(matrix));

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
        Utilities.compare(mst, kruskal.findMST(matrix));

        matrix = new int[][] {
            { 0,  20, 9,  13, 0,  0 },
            { 20, 0,  1,  0,  4,  5 },
            { 9,  1,  0,  2,  0,  0 },
            { 13, 0,  2,  0,  3,  14 },
            { 0,  4,  0,  3,  0,  0 },
            { 0,  5,  0,  14, 0,  0 }
        };

        mst = new int[][] {
            { 0, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 1 },
            { 1, 1, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 1, 0 },
            { 0, 0, 0, 1, 0, 0 },
            { 0, 1, 0, 0, 0, 0 }
        };

        Utilities.compare(mst, prim.findMST(matrix));
        Utilities.compare(mst, kruskal.findMST(matrix));
    }

    private static void testCompare() throws Exception {
        int[] params = Utilities.getRandomGraphParameters();
        System.out.printf("\tGraph parametrs (n = %d, m = %d)\n", params[0], params[1]);
        int[][] matrix = graphMaker.make(5, 10);//params[0], params[1]);
        int[][] primTree = prim.findMST(matrix);
        int[][] kruskalTree = kruskal.findMST(matrix);
        int primWeight = getTreeSumWeight(matrix, primTree);
        int kruskalWeight = getTreeSumWeight(matrix, kruskalTree);
        if (primWeight != kruskalWeight) {
            throw new Exception(
                String.format("Weights of min spanning tree do not match: %d, %d, \nGraph: %s\nPrim\'s: %s\nKruskal\'s: %s",
                    primWeight,
                    kruskalWeight,
                    Utilities.toString(matrix),
                    Utilities.toString(primTree),
                    Utilities.toString(kruskalTree))
            );
        }
    }

    private static int getTreeSumWeight(int[][] matrix, int[][] tree) {
        int weight = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = i + 1; j < matrix.length; j ++) {
                if (tree[i][j] == 1)
                    weight += matrix[i][j];
            }
        }
        return weight;
    }
}