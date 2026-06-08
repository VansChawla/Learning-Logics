public class DeleteMidofLL {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        fast = fast.next.next; // We are skipping one step of slow pointer, so run fast's one step early
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next; // Delete middle node

        return head;
    }
}