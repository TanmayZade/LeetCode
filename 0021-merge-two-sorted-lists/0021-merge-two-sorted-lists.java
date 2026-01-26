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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 = list1, h2 = list2;

        ListNode start = new ListNode(-1);

        ListNode temp = start;

        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }

        while(h1 != null){
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;            
        }
        while(h2 != null){
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;            
        }

        return start.next;
    }
}