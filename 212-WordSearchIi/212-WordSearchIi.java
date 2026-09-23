// Last updated: 9/23/2026, 2:49:08 PM
class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private final List<String> result = new ArrayList<>();
    private int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            insert(root, word);
        }

        rows = board.length;
        cols = board[0].length;

        // DFS from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // Avoid duplicates
        }

        // Mark cell as visited
        board[r][c] = '#';

        dfs(board, r + 1, c, next);
        dfs(board, r - 1, c, next);
        dfs(board, r, c + 1, next);
        dfs(board, r, c - 1, next);

        // Restore cell
        board[r][c] = ch;
    }
}