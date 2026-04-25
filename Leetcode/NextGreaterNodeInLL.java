import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLL {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] array = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                array[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }

        return array;
    }
}
