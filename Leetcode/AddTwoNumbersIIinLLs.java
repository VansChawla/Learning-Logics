import java.util.Stack;

public class AddTwoNumbersIIinLLs {
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

    //-------------------Approach 1: Reverse the linked lists and then add------------------
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr1 = reverseList(l1);
        ListNode lr2 = reverseList(l2);

        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (lr1 != null || lr2 != null) {
            int sum = 0 + carry;
            if (lr1 != null) {
                sum += lr1.val;
                lr1 = lr1.next;
            }
            if (lr2 != null) {
                sum += lr2.val;
                lr2 = lr2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1)
            ptr.next = new ListNode(1);

        return reverseList(result.next);
    }

    //-------------------Approach 2: Using stacks------------------
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int sum = 0 + carry;
            if(!stack1.isEmpty()){
                sum += stack1.pop();
            }
            if(!stack2.isEmpty()){
                sum += stack2.pop();
            }
            
            //Create a new node and link it to the front
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            
            carry = sum / 10;
        }

        return head; 
    }
}