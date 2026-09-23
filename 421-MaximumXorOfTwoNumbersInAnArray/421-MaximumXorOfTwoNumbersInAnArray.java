// Last updated: 9/23/2026, 2:43:13 PM
class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    private TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {

        // Insert all numbers into Trie
        for (int num : nums) {
            insert(num);
        }

        int maxXor = 0;

        // Find maximum XOR for every number
        for (int num : nums) {
            maxXor = Math.max(maxXor, findMaxXor(num));
        }

        return maxXor;
    }

    private void insert(int num) {

        TrieNode node = root;

        // Process 32 bits
        for (int i = 31; i >= 0; i--) {

            int bit = (num >>> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    private int findMaxXor(int num) {

        TrieNode node = root;
        int result = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >>> i) & 1;

            // Opposite bit gives XOR = 1
            int opposite = 1 - bit;

            if (node.child[opposite] != null) {

                result |= (1 << i);
                node = node.child[opposite];

            } else {
                node = node.child[bit];
            }
        }

        return result;
    }
}