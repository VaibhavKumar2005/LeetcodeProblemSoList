class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Dummy node helps simplify result list creation
        // It avoids handling the head separately
        ListNode dummy = new ListNode(0);
        
        // Pointer used to build the new linked list
        ListNode current = dummy;
        
        // Carry from previous digit addition
        int carry = 0;
        
        // Continue while:
        // 1. Either list still has nodes
        // 2. OR carry is still remaining
        while (l1 != null || l2 != null || carry != 0) {
            
            // Start sum with carry from previous step
            int sum = carry;
            
            // If l1 still has a node, add its value
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;   // Move l1 forward
            }
            
            // If l2 still has a node, add its value
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;   // Move l2 forward
            }
            
            // Update carry for next iteration
            carry = sum / 10;
            
            // Create a new node with the last digit of sum
            // (sum % 10 gives the digit to store)
            current.next = new ListNode(sum % 10);
            
            // Move current pointer forward
            current = current.next;
        }
        
        // dummy.next is the actual head of the result list
        return dummy.next;
    }
}
