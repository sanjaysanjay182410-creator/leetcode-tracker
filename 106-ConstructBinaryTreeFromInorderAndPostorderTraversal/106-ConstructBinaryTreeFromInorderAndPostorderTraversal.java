// Last updated: 9/23/2026, 2:54:01 PM
import java.util.*;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postorderIndex = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal);

        // Right subtree first (reverse of preorder approach)
        root.right = build(postorder, inorderIndex + 1, right);
        root.left = build(postorder, left, inorderIndex - 1);

        return root;
    }
}