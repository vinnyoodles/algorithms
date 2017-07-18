public class Trie {

  class Node {
    char letter;
    HashMap<Character, Node> map;
    boolean complete;

    public Node(char letter) {
      this.letter = letter;
      map = new HashMap<Character, Node>();
      complete = false;
    }
  }

  Node root;

  public Trie() {
    this.root = new Node('*');
  }

  public void insert(String word) {
    Node node = this.root;
    int count = 0;

    for (char c : word.toCharArray()) {
      if (!node.map.containsKey(c)) {
        node.map.put(c, new Node(c));
      }

      node = node.map.get(c);
      if (count == word.length() - 1) {
        node.complete = true;
      }
      count ++;
    }
  }

  public boolean search(String word) {
    Node node = this.root;
    int count = 0;
    while (count < word.length()) {
      char letter = word.charAt(count);
      if (!node.map.containsKey(letter)) {
        return false;
      }
      node = node.map.get(letter);
      count++;
    }

    return node.complete;
  }

  public boolean startsWith(String prefix) {
    Node node = this.root;
    int count = 0;
    while (count < prefix.length()) {
      char letter = prefix.charAt(count);
      if (!node.map.containsKey(letter)) {
        return false;
      }
      node = node.map.get(letter);
      count++;
    }
    return true;
  }
}