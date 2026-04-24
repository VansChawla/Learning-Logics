import java.util.Stack;

public class RemoveNodesFromLL {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode lnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = lnext;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode result = new ListNode();
        ListNode ptr = result;
        int max = Integer.MIN_VALUE;
        while (stack.size() > 0) {
            int stele = stack.pop();
            if (stele >= max) {
                max = stele;
                ptr.next = new ListNode(stele);
                ptr = ptr.next;
            }
        }

        return reverseList(result.next);
    }
}
