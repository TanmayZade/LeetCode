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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
         
         while(temp != null){
            ListNode kthNode = getKthNode(temp,k);

            if(kthNode == null){
                if(prevLast != null)
                    prevLast.next = temp;
                break;
            }

            ListNode nxtNode = kthNode.next;
            kthNode.next = null;
            reverseSegment(temp);
            if(temp == head){
                head = kthNode;
            }else
                 prevLast.next = kthNode;

            prevLast = temp;

            temp = nxtNode;
         }
        return head;
    }

    private ListNode reverseSegment(ListNode head){
        ListNode curr = head;
        ListNode prev = null,next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode temp,int k){
        k--;

        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
}