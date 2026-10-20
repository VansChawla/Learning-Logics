class Solution {
    // New Solution
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int size = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while(size < left){
            prev = prev.next;
            size++;
        }
        ListNode curr = prev.next;

        ListNode temp1 = prev; // saving prev node of the to be reversed part
        ListNode temp2 = curr; // saving first node of the to be reversed part

        for(int i=0; i<right-left+1; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // After successful reverse Join last links
        temp1.next = prev;
        temp2.next = curr;

        return dummy.next;
    }

    // Old Solution
    public ListNode ReverseLinkedListII(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lPrev = dummy;
        ListNode curr = head;

        for(int i=0; i<left-1; i++){
            lPrev = lPrev.next;
            curr = curr.next;
        }

        ListNode subListHead = curr;

        ListNode prev = null;
        for(int i=0; i<=right-left; i++){
            ListNode lnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = lnext;
        }

        // Join the pieces
        lPrev.next = prev;
        subListHead.next = curr;

        return dummy.next;
    }
}