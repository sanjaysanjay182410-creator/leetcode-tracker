// Last updated: 9/23/2026, 2:47:05 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;   // copy next node's value
        node.next = node.next.next; // skip the next node
    }
}