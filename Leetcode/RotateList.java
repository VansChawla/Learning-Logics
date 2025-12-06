public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head; // Find length & tail
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        } // current is now tail

        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }
        current.next = head; // Connect tail to head

        int stepToNewTail = length - k; // Find new tail
        ListNode newTail = head;
        for (int i = 1; i < stepToNewTail; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next; // Break the circle & Define the new head
        newTail.next = null;

        return newHead;
    }
}
