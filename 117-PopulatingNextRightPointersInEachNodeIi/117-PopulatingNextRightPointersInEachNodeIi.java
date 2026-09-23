// Last updated: 9/23/2026, 2:53:24 PM
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root;

        while (current != null) {
            // Dummy node to track the start of the next level
            Node dummy = new Node(0);
            Node prev = dummy;

            // Traverse the current level using next pointers
            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }
                current = current.next;
            }

            // Move to the next level
            current = dummy.next;
        }

        return root;
    }
}