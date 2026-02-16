/**
 * LeetCode 83 - Remove Duplicates from Sorted List
 *
 * Problem:
 * Given the head of a sorted linked list, delete all duplicates such that
 * each element appears only once. Return the linked list sorted as well.
 *
 * Approach:
 * - Since the list is already sorted, duplicate values will always appear consecutively.
 * - Traverse the list using a pointer.
 * - If the current node's value is equal to the next node's value,
 *   skip the next node by adjusting the pointer.
 * - Otherwise, move to the next node.
 *
 * Time Complexity: O(n)
 *   - We traverse the list once.
 *
 * Space Complexity: O(1)
 *   - No extra space is used (in-place modification).
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        // Edge case: empty list
        if (head == null) {
            return null;
        }
        
        // Start traversing from head
        ListNode current = head;
        
        // Traverse while next node exists
        while (current != null && current.next != null) {
            
            // If duplicate value found
            if (current.val == current.next.val) {
                
                // Skip the duplicate node
                current.next = current.next.next;
                
            } else {
                
                // Move to next distinct node
                current = current.next;
            }
        }
        
        return head;
    }
}
