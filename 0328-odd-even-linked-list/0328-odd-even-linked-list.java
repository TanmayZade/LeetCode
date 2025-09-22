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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddHead = odd;
        ListNode even = new ListNode(1);
        ListNode evenHead = even;

        ListNode curr = head;

        boolean join = true;

        while(curr != null){
            if(join){
                oddHead.next = curr;
                oddHead = oddHead.next;
            }else{
                evenHead.next = curr;
                evenHead = evenHead.next;
            }
            join = !join;
            curr = curr.next;
        }

        evenHead.next = null;
        oddHead.next = even.next;

        return odd.next;
    }
}