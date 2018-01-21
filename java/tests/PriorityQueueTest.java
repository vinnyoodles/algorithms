import datastructures.PriorityQueue;
import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i ++) {
            testRandomSort(10000 + ((int) (Math.random() * 10000)));
        }
    }

    private static void testRandomSort(int count) throws Exception {
        System.out.printf("\tRandomSort (n = %d)\n", count);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < count; i ++) {
            q.add((int) (Math.random() * Integer.MAX_VALUE));
        }

        if (q.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        if (q.size() != count) {
            throw new Exception("Queue size is incorrect");
        }

        int prev = q.poll();

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr < prev) {
                throw new Exception("Incorrect poll order");
            }
            prev = curr;
        }
    }
}