public class SwappingNodesLL {
    // New
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = head;
        for(int i=1; i<k; i++){
            n1 = n1.next;
        }

        ListNode N1 = n1;
        ListNode n2 = head;
        while(N1.next != null){
            N1 = N1.next;
            n2 = n2.next;
        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
    }

    // Old
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head; // Find the kth node from the begining
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode first = fast;

        ListNode slow = head; // Find the kth node from the end
        while (first.next != null) {
            first = first.next;
            slow = slow.next;
        }

        int temp = fast.val; // swap
        fast.val = slow.val;
        slow.val = temp;

        return head;
    }
}
