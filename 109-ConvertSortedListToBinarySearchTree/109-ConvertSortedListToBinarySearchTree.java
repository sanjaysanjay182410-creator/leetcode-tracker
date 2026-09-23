// Last updated: 9/23/2026, 2:53:54 PM
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode tail) {
        if (head == tail) return null;

        // Find middle node using slow/fast pointers
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = build(head, slow);
        root.right = build(slow.next, tail);

        return root;
    }
}