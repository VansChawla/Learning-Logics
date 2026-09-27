class MaxTwinSumOfLL {
    public int pairSum(ListNode head) {
        // Find Mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        // Reverse second half
        ListNode prev = null;
        ListNode curr = mid;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Calculate Twin Sum
        int max = Integer.MIN_VALUE;
        ListNode secHalfHead = prev;
        while(secHalfHead != null && head != null){
            max = Math.max(secHalfHead.val + head.val, max);
            secHalfHead = secHalfHead.next;
            head = head.next;
        }

        return max;
    }
}