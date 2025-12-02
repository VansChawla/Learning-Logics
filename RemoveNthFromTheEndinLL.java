class RemoveNthFromTheEndinLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        for (int i = 0; i < n; i++) { // Move secondPtr n spaces ahead
            secondPtr = secondPtr.next;
        }

        while (secondPtr.next != null) { // Move both now, untill the next of secondPtr is null
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        firstPtr.next = firstPtr.next.next; // Now we can remove the node next of firstPtr
        return dummy.next;
    }
}
