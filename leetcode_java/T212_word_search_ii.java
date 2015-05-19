public class Solution {
private static class TrieNode {
    char c;
    boolean endOfWord = false, found = false;
    TrieNode[] children = new TrieNode[26];
    TrieNode(char c){this.c = c;}
}

private TrieNode root;
private char[][] board;
private int M;
private int N;
private List<String> result;

public List<String> findWords(char[][] board, String[] words) {
    if(board == null || board.length == 0 || board[0].length == 0 || 
            words == null || words.length == 0)
        return Collections.emptyList();

    this.board = board;
    N = board.length;
    M = board[0].length;

    /** create the Trie **/
    root = new TrieNode('#');
    for(String word: words){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int ind = c - 'a';
            if(node.children[ind] == null)
                node.children[ind] = new TrieNode(c);
            node = node.children[ind];
        }
        node.endOfWord = true;
    }

    /** do search **/
    result = new ArrayList<>();
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            for(TrieNode n: root.children)
                search(new HashSet<Long>(), i, j, new StringBuffer(), n);
    return result;
}

private void search(Set<Long> set, int i, int j, 
        StringBuffer sb, TrieNode node){
    long key = i * M + j;
    if(node == null || i < 0 || i >= N || j < 0 || j >= M || 
            set.contains(key) || board[i][j] != node.c)
        return;

    set.add(key);
    sb.append(node.c);
    if(node.endOfWord && !node.found){
        result.add(sb.toString());
        node.found = true;
    }
    for(TrieNode n: node.children){
        search(set, i - 1, j, sb, n);
        search(set, i + 1, j, sb, n);
        search(set, i, j - 1, sb, n);
        search(set, i, j + 1, sb, n);
    }
    sb.deleteCharAt(sb.length() - 1);
    set.remove(key);
}
}
