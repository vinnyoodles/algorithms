package datastructures;
import java.util.*;

/**
 * This is strictly a min heap.
 */
public class PriorityQueue<T extends Comparable<? super T>> {
    private List<T> heap;
    public PriorityQueue() {
        heap = new ArrayList<>();

        // The first element in the heap is unused.
        // This is because the root element of the heap
        // has an index of 1.
        heap.add(null);
    }

    public int size() {
        return heap.size() - 1;
    }

    public boolean isEmpty() {
        // Do not count the first element.
        return heap.size() <= 1;
    }

    /**
     * Add the value as the right most node in the last level of the heap.
     * Then, compare the value with its parent. If the value is greater
     * then the parent, then swap them. This process continues
     * until a parent is found where it is not greater or the value becomes
     * the heap.
     */
    public void add(T value) {
        // Add the value to the end of the heap.
        // This is represented as the right most child in the last level of the tree/heap.
        heap.add(value);

        // The index of the inserted value.
        int index = size();

        // Keep iterating until the value becomes the root or 
        // the parent of the value is less than the value.
        while (index > 1 && heap.get(index / 2).compareTo(value) > 0) {
            heap.set(index, heap.get(index / 2));
            index = index / 2;
        }
        heap.set(index, value);
    }

    /**
     * Return the root node of the heap.
     * Then, grab the right most node in the last level and set that as the root.
     * Then, compare the new root with its two children and swap with the lesser value.
     * This process continues until the parent is lesser than both children.
     */
    public T poll() {
        if (isEmpty()) return null;
        T min = heap.get(1);

        // Grab the last element and set it as the root.
        int index = size();
        heap.set(1, heap.get(index));
        heap.remove(index);
        if (!isEmpty()) heapify(1);

        return min;
    }

    private void heapify(int index) {
        int left = 2 * index;
        int right = left + 1;
        int minIndex = index;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(minIndex)) < 0) {
            minIndex = left;
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(minIndex)) < 0) {
            minIndex = right;
        }

        if (minIndex != index) {
            T temp = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp);
            heapify(minIndex);
        }

    }
}