class WordDictionary {
  class Node {
    Node[] next;
    boolean isWord;

    Node() {
      next = new Node[26];
    }
  }

  private Node root;

  public WordDictionary() {
    root = new Node();
  }
  
  public void addWord(String word) {
    var node = root;

    for (var c : word.toCharArray()) {
      var i = c - 'a';
      
      if (node.next[i] == null)
        node.next[i] = new Node();
      
      node = node.next[i];
    }
    node.isWord = true;
  }

  private boolean search(String word, int idx, Node node) {
    if (idx == word.length())
      return node == null || node.isWord;

    for (var i = idx; i < word.length() && node != null; i++) {
      var c = word.charAt(i);

      if (c == '.') {
        for (var nextNode : node.next)
          if (nextNode != null && search(word, i+1, nextNode))
            return true;
        
        return false;
      }
      node = node.next[c - 'a'];
    }
    return node != null && node.isWord;
  }
  
  public boolean search(String word) {
    return search(word, 0, root);
  }
}