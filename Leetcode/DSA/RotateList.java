public class RotateList {

    //Brute Force Approach OR Array Right Rotation Approach
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Get total length to handle large k values
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k == 0) return head;

        //Reverse Whole LL
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next; //Initialize next
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode newHead = prev;

        //Reverse first k elements
        int count = 0;
        ListNode prev2 = null;
        ListNode curr2 = newHead;
        ListNode next2 = null;
        while(curr2 != null && count < k){
            next2 = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = next2;
            count++;
        }

        // prev2 is the new head of the first part
        // newHead is now the tail of the first part
        // curr2 holds the start node of the remaining unreversed part

        // Reverse remaining half
        ListNode prev3 = null;
        ListNode curr3 = curr2;
        ListNode next3 = null;
        while (curr3 != null) {
            next3 = curr3.next;
            curr3.next = prev3;
            prev3 = curr3;
            curr3 = next3;
        }

        newHead.next = prev3;
        return prev2;
    }

    //Shortest Approach OR Optimal Approach
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head; // Find length & tail
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        } // current is now tail

        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }
        current.next = head; // Connect tail to head

        int stepToNewTail = length - k; // Find new tail
        ListNode newTail = head;
        for (int i = 1; i < stepToNewTail; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next; // Break the circle & Define the new head
        newTail.next = null;

        return newHead;
    }
}
