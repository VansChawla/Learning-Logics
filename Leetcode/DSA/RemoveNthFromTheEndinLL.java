class RemoveNthFromTheEndinLL {

    //Brute force approach
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }

        //Edge case: If removing the head node
        if (size == n) return head.next;
        
        int i=0;
        ListNode node = head;
        while(i < size-n-1){
            node = node.next;
            i++;
        }
        node.next = node.next.next;
        return head;
    }

    // Two pointer approach
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
