public class DeleteNodeLL {
    public void deleteNode(ListNode node) {
        // We are copying the value of next node in current node
        node.val = node.next.val;
        // Then delete that next node
        node.next = node.next.next;
    }
}
