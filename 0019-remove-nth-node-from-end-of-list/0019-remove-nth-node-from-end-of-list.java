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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int idx = size - n ;
        if(idx == 0)    return head.next;
        ListNode prev = null;
        ListNode curr = head;
        int i = 0;
        while(i < idx){
            prev = curr;
            curr = curr.next;
            i++;
        }
        prev.next = curr.next;
        return head;
    }
}