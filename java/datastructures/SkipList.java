package datastructures;

public class SkipList {
    class SkipNode {
        int value;
        SkipNode next;
        SkipNode child;

        public SkipNode(int v) {
            this.value = v;
        }
    }

    SkipNode headerNode;
    int max;
    int length;

    public SkipList() {
        headerNode = new SkipNode(-1);
        max = 0;
        length = 0;
    }

    public void add(int value) throws Exception {
        SkipNode[] path = new SkipNode[max + 1];
        find(value, path);

        int index = 0;
        SkipNode prevChild = null;
        do {
            SkipNode prev;
            if (index < path.length) {
                prev = path[index++];
            } else {
                // New level must be added to header node
                prev = new SkipNode(-1);
                prev.child = headerNode;
                headerNode = prev;
                max ++;
            }

            // Linked list insertion.
            SkipNode next = prev.next;
            if (next != null && next.value < value) {
                throw new Exception(String.format("Inserting at invalid location, level: %d", index));
            }
            prev.next = new SkipNode(value);
            prev.next.next = next;

            // Update new node column.
            prev.next.child = prevChild;
            prevChild = prev.next;
        } while (Math.random() < 0.5);
        length ++;
    }

    // If the value is duplicated, then delete the first instance of value.
    public boolean delete(int value) throws Exception {
        SkipNode[] path = new SkipNode[max + 1];
        // Does not exist.

        SkipNode currentNode = headerNode;
        int index = path == null ? -1 : path.length - 1;
        boolean found = false;

        while (currentNode != null) {
            // Traverse horizontally.
            while (currentNode.next != null && currentNode.next.value < value) {
                currentNode = currentNode.next;
            }

            if (currentNode.next != null && currentNode.next.value == value)
                found = true;

            if (path != null) {
                path[index--] = currentNode;
            }
            // Traverse vertically.
            currentNode = currentNode.child;
        }

        if (!found) return false;

        for (SkipNode pathNode : path) {
            // There is nothing to delete if the next node is null.
            if (pathNode.next == null) continue;

            // This is a safety check as this should never be true.
            if (pathNode.next.value < value) throw new Exception("Invalid path");

            // Perform linked list deletion of the next node.
            if (pathNode.next.value == value) {
                SkipNode temp = pathNode.next.next;
                pathNode.next = temp;
            }
        }
        length --;
        return true;
    }

    public boolean find(int value) {
        return find(value, null /*path*/);
    }

    public int[] toArray() {
        StringBuilder b = new StringBuilder();
        int[] result = new int[length];
        int index = 0;
        SkipNode temp = headerNode;

        // Traverse to level 0.
        while (temp.child != null)
            temp = temp.child;

        // Skip header node.
        temp = temp.next;

        while (temp != null) {
            result[index++] = temp.value;
            temp = temp.next;
        }
        return result;
    }

    private boolean find(int value, SkipNode[] path) {
        SkipNode currentNode = headerNode;
        int index = path == null ? -1 : path.length - 1;
        boolean found = false;

        while (currentNode != null) {
            // Traverse horizontally.
            while (currentNode.next != null && currentNode.next.value <= value) {
                // The reason we don't just return here is because
                // we want to find the exact location/path to level 0 for the given value.
                // This is because we support inserting duplicates.
                if (currentNode.next.value == value) {
                    found = true;
                }
                currentNode = currentNode.next;
            }

            if (path != null) {
                path[index--] = currentNode;
            }
            // Traverse vertically.
            currentNode = currentNode.child;
        }

        return found;
    }
}