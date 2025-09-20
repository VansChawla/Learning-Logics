class RemoveNthFromTheEndinLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Calculate Size of LL
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(n==size){
            head = head.next;
            return head;
        }

        //size-n
        int i=1;
        int iToFind=size-n;
        ListNode prev = head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}
