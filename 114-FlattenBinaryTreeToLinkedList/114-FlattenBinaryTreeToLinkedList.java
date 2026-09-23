// Last updated: 9/23/2026, 2:53:37 PM
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode current = root;
        while (current != null) {
            // If left child exists, find its rightmost node (predecessor)
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Connect predecessor's right to current's right
                predecessor.right = current.right;

                // Move left to right, set left to null
                current.right = current.left;
                current.left = null;
            }

            // Move to next node (right side)
            current = current.right;
        }
    }
}