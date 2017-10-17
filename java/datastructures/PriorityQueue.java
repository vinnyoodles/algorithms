import java.util.*;
/**
 * This is strictly a min heap.
 */
public class PriorityQueue {
    private List<Integer> heap;
    public PriorityQueue() {
        heap = new ArrayList<>();

        // The first element in the heap is unused.
        // This is because the root element of the heap
        // has an index of 1.
        heap.add(0);
    }

    public int size() {
        return heap.size();
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
    public void add(int value) {
        // Add the value to the end of the heap.
        // This is represented as the right most child in the last level of the tree/heap.
        heap.add(value);
        if (isEmpty()) {

            // Return now because there is only one element in the heap.
            // Therefore, it has nothing to compare to.
            return;
        }

        // The index of the inserted value.
        int index = heap.size() - 1;
        int parentIndex = index / 2;
        int parentVal = heap.get(parentIndex);

        // Keep iterating until the value becomes the root or 
        // the parent of the value is less than the value.
        while (index > 1 && parentVal > value) {
            // Swap the parent and the current node.
            heap.set(index, parentVal);
            heap.set(parentIndex, value);

            // Update the variables.
            index = parentIndex;
            parentIndex = index / 2;
            parentVal = heap.get(parentIndex);
        }
    }

    /**
     * Return the root node of the heap.
     * Then, grab the right most node in the last level and set that as the root.
     * Then, compare the new root with its two children and swap with the greater value.
     * This process continues until the parent is the greater than both children.
     */
    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int min = heap.get(1);

        // Grab the last element and set it as the root.
        int index = heap.size() - 1;
        heap.set(1, heap.get(index));
        heap.remove(index);

        // Update the index to be the root node.
        index = 1;
        int leftIndex = index * 2;
        int rightIndex = leftIndex + 1;

        // Keep iterating until the value becomes the last value in the heap 
        // or the value is less than both left and right children.
        while (index < heap.size() && (
            (leftIndex < heap.size() && heap.get(index) > heap.get(leftIndex)) ||
            (rightIndex < heap.size() && heap.get(index) > heap.get(rightIndex)))) {

            // Check if the right child exists.
            int right = rightIndex < heap.size() ? heap.get(rightIndex) : Integer.MAX_VALUE;
            // Check if the left child exists.
            int left = leftIndex < heap.size() ? heap.get(leftIndex) : Integer.MAX_VALUE;
            // Grab the lesser of the two.
            int childIndex = left > right ? rightIndex : leftIndex;
            int temp = heap.get(index);

            // Swap parent and child elements.
            heap.set(index, heap.get(childIndex));
            heap.set(childIndex, temp);

            // Update variables
            index = childIndex;
            leftIndex = index * 2;
            rightIndex = leftIndex + 1;
        }

        return min;
    }

}