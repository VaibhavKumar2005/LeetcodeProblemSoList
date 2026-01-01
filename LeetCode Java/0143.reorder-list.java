class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        int start = 0;
        int end = nodes.size() - 1;

        while (start < end) {
            nodes.get(start).next = nodes.get(end);
            start++;

            if (start == end) {
                break;
            }

            nodes.get(end).next = nodes.get(start);
            end--;
        }

        nodes.get(start).next = null;
    }
}
