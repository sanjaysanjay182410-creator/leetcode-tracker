// Last updated: 9/23/2026, 2:53:44 PM
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // Leaf node
        if (root.left == null && root.right == null) return 1;

        // Only one child exists
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        // Both children exist
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}