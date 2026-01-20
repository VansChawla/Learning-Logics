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
class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curr = head;
        ListNode lnext = head.next;

        while(lnext != null){
            if(curr.val == lnext.val){
                curr.next = lnext.next;
                lnext = lnext.next;

            } else {
                curr = curr.next;
                lnext = lnext.next;
            }
        }

        return head;
    }
}