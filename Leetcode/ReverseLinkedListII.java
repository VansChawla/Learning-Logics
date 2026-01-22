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
    public ListNode ReverseLinkedListII(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lPrev = dummy;
        ListNode curr = head;

        for(int i=0; i<left-1; i++){
            lPrev = lPrev.next;
            curr = curr.next;
        }

        ListNode subListHead = curr;

        ListNode prev = null;
        for(int i=0; i<=right-left; i++){
            ListNode lnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = lnext;
        }

        // Join the pieces
        lPrev.next = prev;
        subListHead.next = curr;

        return dummy.next;
    }
}