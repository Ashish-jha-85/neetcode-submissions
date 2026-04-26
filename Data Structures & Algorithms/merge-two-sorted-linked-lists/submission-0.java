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
        ListNode result = null;
        ListNode tail = null;
        while (list1 != null && list2 != null){
            ListNode newNode;
            
            if(list1.val < list2.val){
                 newNode = list1;
                 list1 = list1.next;
            }
            else{
                newNode = list2;
                 list2 = list2.next;
            }
            if (result == null){
                result = newNode;
                tail = newNode;
            }
            else{
               tail.next = newNode;
                tail = newNode;
            }
        }
    if(list1 != null){
       if (result == null) return list1;
       tail.next = list1;
    }
    else {
         if (result == null) return list2;
       tail.next = list2;
    }
    return result;
    }
}