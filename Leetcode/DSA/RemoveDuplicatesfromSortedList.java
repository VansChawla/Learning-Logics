class RemoveDuplicatesfromSortedList {
    // With two pointers
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nodeA = head;

        while(nodeA != null){
            ListNode nodeB = nodeA.next;

            while(nodeB != null && nodeA.val == nodeB.val){
                nodeB = nodeB.next;
            }

            nodeA.next = nodeB;
            nodeA = nodeB;
        }

        return head;
    }

    // With only one pointer
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