// Last updated: 9/23/2026, 2:49:52 PM
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Traverse this level; the last node processed is the rightmost one
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Only add the rightmost node of each level
                if (i == size - 1) {
                    result.add(node.val);
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
}