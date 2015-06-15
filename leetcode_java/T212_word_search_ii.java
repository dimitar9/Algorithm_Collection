public class Solution {
    Set<String> res = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (visited[x][y]) return;

        str += board[x][y];
        if (!trie.startsWith(str)) return;

        if (trie.search(str)) {
            res.add(str);
        }

        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }
}

class TrieNode {
    private final int R = 26;
    private final TrieNode[] children;
    private String item;

    public TrieNode() {
        children = new TrieNode[R];
        item = "";
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public TrieNode getChild(int i) {
        if (i >= 26 || i < 0) throw new IllegalArgumentException();
        return children[i];
    }

    public void setChild(int i, TrieNode node) {
        children[i] = node;
    }
}

 class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c - 'a') == null) curr.setChild(c - 'a', new TrieNode());
            curr = curr.getChild(c - 'a');
        }
        curr.setItem(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c - 'a') == null) return false;
            curr = curr.getChild(c - 'a');
        }
        return curr.getItem().equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.getChild(c - 'a') == null) return false;
            curr = curr.getChild(c - 'a');
        }
        return true;
    }
}
