public class LRUCache {
  public class LinkedListNode {
    LinkedListNode prev;
    LinkedListNode next;
    int element;
    int key;

    public LinkedListNode(int key, int t) {
      this.element = t;
      this.key = key;
      this.prev = this.next = null;
    }
  }

  HashMap<Integer, LinkedListNode> map;
  LinkedListNode head;
  LinkedListNode tail;
  int size;
  int capacity;

  public LRUCache(int capacity) {
    map = new HashMap<Integer, LinkedListNode>();
    this.size = 0;
    this.capacity = capacity;
  }

  public int get(int key) {
    LinkedListNode node = this.map.get(key);

    if (node == null) return -1;

    this.update(node);
    return node.element;
  }

  public void put(int key, int value) {
    if (this.head == null) {
      this.tail = this.head = new LinkedListNode(key, value);
      this.map.put(key, this.head);
      this.size ++;
      return;
    }

    // Check for duplicates
    LinkedListNode node = this.map.get(key);
    if (node == null) {
      // If the key does not exist in the map.
      if (this.size >= this.capacity) {
        // Evict the least recently used node (the tail of the list).
        LinkedListNode tailNode = this.tail;
        if (tailNode.prev != null) tailNode.prev.next = null;
        this.tail = tailNode.prev;

        // Remove the node from the map as well.
        this.map.remove(tailNode.key);
        this.size--;
      }
      LinkedListNode newNode = new LinkedListNode(key, value);
      this.update(newNode);

      // Add the node to the map under the key.
      this.map.put(key, newNode);
      this.size ++;
      return;
    }
    node.element = value;

    // The key is already in the map.
    // Update the value and move the node to the head of the list.
    this.update(node);
  }

  private void update(LinkedListNode node) {
    // If the node is the head node, then return.
    if (node == this.head) return;

    // If there is only 1 node in the list.
    else if (this.head == this.tail) {
      node.next = this.tail;
      this.tail.prev = node;
      this.head = node;
      return;
    }

    LinkedListNode prevNode = node.prev;

    // If the node does not exist in the list, then add as the head (new node).
    if (prevNode == null) {
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
      return;
    }

    // If the node that is being updated is the tail, then we must set a new tail.
    if (this.tail == node) {
      prevNode.next = null;
      this.tail = prevNode;
    } else {
      // Otherwise, remove the node from the list.
      prevNode.next = node.next;
      node.next.prev = prevNode;
    }

    // Now add the node to the front
    node.prev = null;
    node.next = this.head;
    this.head.prev = node;
    this.head = node;
  }
}
