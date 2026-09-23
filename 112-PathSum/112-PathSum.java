// Last updated: 9/23/2026, 2:53:40 PM
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // Leaf node: check if current sum matches target
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recurse on children with reduced sum
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}