// Last updated: 9/23/2026, 2:54:09 PM
import java.util.*;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        preorderIndex = 0;
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal);

        // Left subtree first (matches preorder traversal order)
        root.left = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
}