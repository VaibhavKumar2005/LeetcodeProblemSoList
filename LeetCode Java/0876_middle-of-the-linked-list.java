/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode middleNode(ListNode head) {
        
        // Initialize two pointers
        // slow moves 1 step at a time
        // fast moves 2 steps at a time
        ListNode slow = head;
        ListNode fast = head;

        // Traverse until fast reaches the end
        while (fast != null && fast.next != null) {
            
            slow = slow.next;          // Move slow by 1 step
            fast = fast.next.next;     // Move fast by 2 steps
        }

        // When fast reaches null,
        // slow will be at the middle
        // (second middle in case of even length)
        return slow;
    }
}
