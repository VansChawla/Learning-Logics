public class MergekSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // Base case: if the array is empty, return null
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a Min-Heap that sorts ListNodes based on their integer value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 1. Add the head of every non-empty list into the Min-Heap
        for (ListNode listHead : lists) {
            if (listHead != null) {
                minHeap.offer(listHead);
            }
        }

        // 2. Create a dummy head to easily build our result list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 3. Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            // Pop the absolute smallest node currently available
            ListNode smallestNode = minHeap.poll();

            // Attach it to our result list
            current.next = smallestNode;
            current = current.next; // Move our pointer forward

            // If the node we just popped has a next node in its original list,
            // push that next node into the heap!
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        // Return the merged list, skipping the dummy head
        return dummy.next;
    }
}
