public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) { // If curr node is duplicate

                while (curr.next != null && curr.val == curr.next.val) { // Move to the last duplicate node
                    curr = curr.next;
                }

                prev.next = curr.next; // Skip the duplicate node
            } else {
                prev = prev.next; // We have found a unique node
            }

            curr = curr.next; // Move to next node
        }

        return dummy.next; // Return head
    }
}
