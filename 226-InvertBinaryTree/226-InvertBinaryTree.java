// Last updated: 9/23/2026, 2:47:57 PM
class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // Swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
