public class SwappingNodesLL {
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
