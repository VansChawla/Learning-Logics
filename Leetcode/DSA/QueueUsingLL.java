public class QueueUsingLL {
    // Node class
    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    // Queue class
    class myQueue {
        Node start;
        Node end;
        int size;
        public myQueue() {
            size = 0;
            start = null;
            end = null;
        }

        public boolean isEmpty() {
            return start == null;
        }

        public void enqueue(int x) {
            Node temp = new Node(x);
            
            if(start == null){
                start = temp;
                end = temp;
            } else {
                end.next = temp;
                end = temp;
            }
            
            size++;
        }

        public void dequeue() {
            if(start == null) return;
            
            start = start.next;
            size--;
        }

        public int getFront() {
            if(start == null) return -1;
            return start.data;
        }

        public int size() {
            return size;
        }
    }
}
