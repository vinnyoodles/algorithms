import datastructures.PriorityQueue;
import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i ++) {
            testRandomSort(10000 + ((int) (Math.random() * 10000)));
            testRandomSortAndInsert(10000 + ((int) (Math.random() * 10000)));
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

            if (curr < prev) throw new Exception("Incorrect poll order");
            prev = curr;
        }
    }

    private static void testRandomSortAndInsert(int count) throws Exception {
        System.out.printf("\tRandomSortAndInsert (n = %d)\n", count);
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

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (q.isEmpty()) break;
            int next = q.poll();

            if (curr > next) throw new Exception("Incorrect poll order");

            if (Math.random() < 0.5) {
                q.add((int) (Math.random() * Integer.MAX_VALUE));
            }
        }
    }
}