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
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        if(head == null || head.next == null || head.next.next == null ) return false;
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next.next;
        while ( fast.next != null && fast.next.next != null){
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
