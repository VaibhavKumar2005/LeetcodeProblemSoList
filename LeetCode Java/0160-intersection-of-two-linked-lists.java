/**
 * Solution for LeetCode 160: Intersection of Two Linked Lists.
 * * Algorithm: Two-Pointer Technique
 * Time Complexity: O(m + n) - Each node is visited at most twice.
 * Space Complexity: O(1) - Only two pointers are used regardless of list size.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, there is no intersection by definition.
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // The core logic: If they intersect, they will meet at the node.
        // If they don't, they will both reach null at the same time after 
        // traversing (lengthA + lengthB) nodes.
        while (pA != pB) {
            // If pA reaches the end of list A, redirect it to the head of list B.
            // Otherwise, move to the next node.
            pA = (pA == null) ? headB : pA.next;
            
            // Similarly, if pB reaches the end of list B, redirect it to head A.
            pB = (pB == null) ? headA : pB.next;
        }

        // Returns the intersection node if found, or null if lists don't meet.
        return pA;
    }
}
