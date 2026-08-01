import org.w3c.dom.Node;

public class StackUsingLL {
    class myStack {
        Node top;
        int size;

        public myStack() {
            size = 0;
            top = null;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(int x) {
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            size++;
        }

        public void pop() {
            if(isEmpty()) return;
            top = top.next;
            size--;
        }

        public int peek() {
            if(isEmpty()) return -1;
            return top.data;
        }

        public int size() {
            return size;
        }
    }
}
