// Last updated: 9/23/2026, 2:52:47 PM
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        
        currentSum = currentSum * 10 + node.val;
        
        // Leaf node
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}