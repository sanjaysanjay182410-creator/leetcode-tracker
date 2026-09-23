// Last updated: 9/23/2026, 2:53:02 PM
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        
        // Max sum from left/right subtree (ignore negative paths — take 0)
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);
        
        // Path that goes through this node
        int currentMax = node.val + left + right;
        maxSum = Math.max(maxSum, currentMax);
        
        // Return max single-branch path to continue upward
        return node.val + Math.max(left, right);
    }
}