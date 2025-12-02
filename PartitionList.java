public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode higher = new ListNode(0);

        // Pointers
        ListNode smallHead = small;
        ListNode higherHead = higher;

        while (head != null) {
            if (head.val < x) {
                // Small list
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                // Higher list
                higherHead.next = head;
                higherHead = higherHead.next;
            }

            head = head.next;
        }

        // Merge these two lists
        higherHead.next = null;
        smallHead.next = higher.next;

        return small.next;
    }
}
