/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            } 
        }
        if(!isCycle) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            prev = fast;
        }

        return slow;
    }
}
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode marker = new ListNode(-1);

//         ListNode curr = head;

//         while(curr != null){
//             if(curr.next == marker)
//                 return curr;
            
//             ListNode nextNode = curr.next;
//             curr.next = marker;
//             curr = nextNode;
//         }
//         return null;
//     }
// }