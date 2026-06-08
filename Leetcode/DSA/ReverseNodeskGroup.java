public class ReverseNodeskGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        // Check if k nodes exist
        while (count < k) {
            if (temp == null)
                return head;
            temp = temp.next;
            count++;
        }

        // Recursively call for rest of LL
        ListNode prevNode = reverseKGroup(temp, k);

        // Reverse Current Group
        temp = head;
        count = 0;
        while (count < k) {
            ListNode next = temp.next; // temp.next ----> next
            temp.next = prevNode; // temp.next ----> prevNode

            prevNode = temp; // change prevNode to temp
            temp = next; // change temp to next

            count++;
        }

        return prevNode;
    }
}
