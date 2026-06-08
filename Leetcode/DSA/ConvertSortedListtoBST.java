import javax.swing.tree.TreeNode;

public class ConvertSortedListtoBST {
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
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public TreeNode sortedListToBST(ListNode head) {
        // Base Case 1: Empty list means no tree
        if (head == null)
            return null;

        // Base Case 2: Only one node left, it becomes a leaf node
        if (head.next == null)
            return new TreeNode(head.val);

        // 1. Find the middle of the linked list
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Disconnect the left half of the list from the middle
        // 'prev' is the node right before 'slow'. Setting its next to null severs the
        // list.
        if (prev != null) {
            prev.next = null;
        }

        // 3. The middle element becomes our current root
        TreeNode root = new TreeNode(slow.val);

        // 4. Recursively build the left subtree using the left half of the list
        // Note: 'head' still points to the very beginning of the disconnected left half
        root.left = sortedListToBST(head);

        // 5. Recursively build the right subtree using the right half of the list
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
