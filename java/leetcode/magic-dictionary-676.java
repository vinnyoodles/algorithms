class MagicDictionary {

  Node root;
  /** Initialize your data structure here. */
  public MagicDictionary() {
    this.root = new Node('*');
    // System.out.println("");
  }

  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    for (String s : dict) root.insert(s);
  }

  /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
  public boolean search(String word) {
    return root.search(word);
  }

  class Node {
    HashMap<Character, Node> map;
    boolean complete;
    int matches = 0;

    public Node() {
      map = new HashMap<>();
      complete = false;
    }

    public void insert(String word) {
      insertHelper(word, 0);
    }

    public void insertHelper(String word, int i) {
      if (i >= word.length()) {
        return;
      }
      Node child = map.getOrDefault(word.charAt(i), new Node());
      child.insertHelper(word, i + 1);
      if (i == word.length() - 1) {
        child.complete = true;
      }
      map.put(word.charAt(i), child);
    }

    public boolean search(String word) {
      boolean result = searchHelper(word, 0);
      return result;
    }

    public boolean searchHelper(String word, int i) {
      if (i >= word.length()) {
        return false;
      }
      char cur = word.charAt(i);
      for (char key : map.keySet()) {
        if (key == cur) {
          if (map.get(key).searchHelper(word, i + 1)) {
            return true;
          }
        } else {
          if (map.get(key).trueSearch(word, i + 1)) {
            return true;
          }
        }
      }
      return false;

    }

    public boolean trueSearch(String word, int i) {
      if (i >= word.length()) {
        return complete;
      }
      if (!map.containsKey(word.charAt(i))) {
        return false;
      }
      return map.get(word.charAt(i)).trueSearch(word, i + 1);
    }
  }
}
