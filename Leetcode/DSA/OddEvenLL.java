public class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode curr1 = head; // Odd
        ListNode curr2 = head.next; // Even

        ListNode temp2 = curr2; // saving starting node of even list

        while(curr2 != null && curr2.next != null){
            // We can also do: curr1.next = curr1.next.next;
            curr1.next = curr2.next;
            curr1 = curr1.next;

            // curr2.next = curr2.next.next;
            curr2.next = curr1.next;
            curr2 = curr2.next;
        }

        // Join Odd's last to even's start
        curr1.next = temp2;

        return head;
    }
}
