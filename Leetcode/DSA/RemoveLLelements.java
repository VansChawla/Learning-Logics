public class RemoveLLelements {
    // With two pointers
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(curr.val == val){
                prev.next = prev.next.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    // With only one pointer
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
