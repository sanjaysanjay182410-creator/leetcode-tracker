// Last updated: 9/23/2026, 2:54:12 PM
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (leftToRight) {
                    TreeNode node = deque.pollFirst();
                    currentLevel.add(node.val);
                    if (node.left != null) deque.offerLast(node.left);
                    if (node.right != null) deque.offerLast(node.right);
                } else {
                    TreeNode node = deque.pollLast();
                    currentLevel.add(node.val);
                    if (node.right != null) deque.offerFirst(node.right);
                    if (node.left != null) deque.offerFirst(node.left);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }
}