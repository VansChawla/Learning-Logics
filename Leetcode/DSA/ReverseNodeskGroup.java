public class ReverseNodeskGroup {
    // Iterative approach
    public ListNode reverseKGroup(ListNode head, int k) {
       int len = 0;
       ListNode curr = head;
       while(curr != null){
            len++;
            curr = curr.next;
       }

       ListNode dummy = new ListNode(0);
       dummy.next = head;

        int times = len/k; // total no of reverses
        curr = head;
        // p1 & p2 for fixing links after reverse
        // p1 for starting node
        // p2 for ending node
        ListNode p1 = dummy;

       for(int i=0; i<times; i++){
            int count = 0;
            ListNode prev = null;
            ListNode p2 = curr;

            while(count < k && curr != null){
                count++;

                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            p1.next = prev;
            p2.next = curr;

            p1 = p2;
       }

       return dummy.next;
    }

    // Recursive approach
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
