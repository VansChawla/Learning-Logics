import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    // Implement Stack using Single Queue
    class MyStack {
        Queue<Integer> q;
        public MyStack() {
            q = new LinkedList<>();
        }
        
        public void push(int x) {
            int s = q.size();
            q.add(x);
            for(int i=0; i<s; i++){
                q.add(q.remove());
            }
        }
        
        public int pop() {
            return q.remove();
        }
        
        public int top() {
            return q.peek();
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }

    // Implement Stack using Two Queues
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            if (q1.isEmpty() == true) {
                q1.add(x);
            } else {
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
                q1.add(x);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
        }

        public int pop() {
            if (!q1.isEmpty()) {
                return q1.remove();
            }
            return -1;
        }

        public int top() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
            }
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}