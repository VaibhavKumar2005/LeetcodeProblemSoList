/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public boolean hasCycle(ListNode head) {
        
        // Initialize two pointers: slow and fast
        // Both start at the head of the list
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list while fast pointer and its next are not null
        // If fast reaches null → no cycle exists
        while (fast != null && fast.next != null) {
            
            // Move slow pointer by 1 step
            slow = slow.next;
            
            // Move fast pointer by 2 steps
            fast = fast.next.next;

            // If slow and fast meet at any point,
            // it means a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If we exit the loop, fast reached null
        // So there is no cycle
        return false;
    }
}
l
