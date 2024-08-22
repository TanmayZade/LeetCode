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
    public ListNode reverseList(ListNode head1) {
        ListNode head = head1;
        ListNode tail = null;
        ListNode prev = null;
        ListNode curr = tail = head;
        ListNode next ;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}