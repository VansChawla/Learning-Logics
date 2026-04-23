public class AddTwoNumbersIIinLLs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode lnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = lnext;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr1 = reverseList(l1);
        ListNode lr2 = reverseList(l2);

        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (lr1 != null || lr2 != null) {
            int sum = 0 + carry;
            if (lr1 != null) {
                sum += lr1.val;
                lr1 = lr1.next;
            }
            if (lr2 != null) {
                sum += lr2.val;
                lr2 = lr2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1)
            ptr.next = new ListNode(1);

        return reverseList(result.next);
    }
}