// Last updated: 9/23/2026, 2:46:44 PM
import java.util.Random;

class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode current = head;
        int result = current.val;
        int count = 1;

        while (current != null) {
            // With probability 1/count, replace result with current node
            if (random.nextInt(count) == 0) {
                result = current.val;
            }
            count++;
            current = current.next;
        }

        return result;
    }
}