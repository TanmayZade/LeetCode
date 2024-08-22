class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from `left` to `right`
        ListNode leftPrev = prev;
        ListNode curr = prev.next;
        ListNode sublistTail = curr;
        ListNode next = null;

        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect the reversed sublist back to the main list
        if (leftPrev != null) {
            leftPrev.next.next = curr;
            leftPrev.next = prev;
        } else {
            head = prev;
        }

        return dummy.next;
    }
}
