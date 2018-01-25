import datastructures.DisjointSet;
public class DisjointSetTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i ++) {
            testSingleSet((int) (Math.random() * 100) + 100);
            testDoubleSet((int) (Math.random() * 100) + 100);
        }
    }

    private static void testSingleSet(int n) throws Exception {
        System.out.printf("\tTestSingleSet (n = %d)\n", n);
        DisjointSet set = new DisjointSet(n);

        // Place all the elements in the same set.
        for (int i = 2; i <= n; i ++)
            set.union(1, i);

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (set.find(i) != set.find(j)) throw new Exception("Elements should be in the same set");
            }
        }
    }

    private static void testDoubleSet(int n) throws Exception {
        System.out.printf("\tTestDoubleSet (n = %d)\n", n);
        DisjointSet set = new DisjointSet(n);
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        // Place the elements in two exclusive sets.
        for (int i = 3; i <= n; i ++) {
            int parent = Math.random() < 0.5 ? 1 : 2;
            set.union(parent, i);
            arr[i] = parent;
        }

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (arr[i] == arr[j] && set.find(i) != set.find(j))
                    throw new Exception("Elements should be in the same set");
                else if (arr[i] != arr[j] && set.find(i) == set.find(j)) 
                    throw new Exception("Elements should not be in the same set");
            }
        }
    }
}