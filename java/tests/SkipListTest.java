import datastructures.SkipList;
import tools.Utilities;

public class SkipListTest {
    static SkipList sList;
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i ++)
            testSimpleUniqueInsertion(50 + ((int) (Math.random() * 50)));
    }

    private static void testSimpleUniqueInsertion(int length) throws Exception {
        System.out.printf("\tTestSimpleUniqueInsertion (n = %d)\n", length);
        SkipList list = new SkipList();
        boolean[] visited = new boolean[1024];
        for (int i = 0; i < length; i ++) {
            // Find a unique element to insert.
            int value;
            do {
                value = (int) (Math.random() * 100) + 1;
            } while (visited[value]);
            visited[value] = true;

            list.add(value);
        }

        int[] array = list.toArray();

        for (int i = 0; i < array.length - 1; i ++) {
            if (array[i] >= array[i + 1]) throw new Exception(String.format("Invalid sorted order: %s", Utilities.toString(array)));
        }
    }
}