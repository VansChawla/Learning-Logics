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
    public ListNode SwapNodesinPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while(head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            //Swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            //Move Pointers
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}

// MY BRUTEFORCE APPROACH BUT WRONG FOR SOME TESTCASES
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         if(head == null || head.next == null){
//             return head;
//         }

//         ListNode curr = head;
//         ListNode lnext = head.next.next;
//         if(lnext != null && lnext.next != null){
//             int temp = curr.next.val;
//             curr.next.val = curr.val;
//             curr.val = temp;

//             int temp2 = lnext.next.val;
//             lnext.next.val = lnext.val;
//             lnext.val = temp2;

//             lnext = lnext.next;
//             curr = curr.next;
//         } else {
//             int temp = curr.next.val;
//             curr.next.val = curr.val;
//             curr.val = temp;
//         }

//         return head;
//     }
// }