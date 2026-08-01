public class QueueUsingStack {
    // Approach 2 - Striver
    class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void push(int x) {
            s1.push(x);        
        }
        
        public int pop() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }
        
        public int peek() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }
        
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    // Appraoch 1 
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        public QueueUsingTwoStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        
        public void push(int x) {
            s1.push(x);
        }
        
        public int pop() {
            if(s2.empty()){
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
        
        public int peek() {
            if(s2.empty()){
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
        
        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }
}