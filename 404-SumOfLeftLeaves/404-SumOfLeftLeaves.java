// Last updated: 9/23/2026, 2:44:19 PM
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check if left child exists and is a leaf
        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {

            sum += root.left.val;
        }

        // Recursively check left and right subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}