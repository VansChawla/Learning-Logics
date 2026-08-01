public class QueueUsingArray {
    class myQueue {
        int currSize;
        int start;
        int end;
        int Q[];
        public myQueue(int n) {
            currSize = 0;
            start = -1;
            end = -1;
            Q = new int[n];
        }

        public boolean isEmpty() {
            return currSize == 0;
        }

        public boolean isFull() {
            return currSize == Q.length;
        }

        public void enqueue(int x) {
            if(isFull()) return;
            
            if(isEmpty()){
                start = 0;
                end = 0;
            } else {
                end = (end + 1) % Q.length;
            }
            Q[end] = x;
            currSize++;
        }

        public void dequeue() {
            if(isEmpty()) return;
            
            if(currSize == 1){
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % Q.length;
            }
            
            currSize--;
        }

        public int getFront() {
            if(!isEmpty())
                return Q[start];
            return -1;
        }

        public int getRear() {
            if(!isEmpty())
                return Q[end];
            return -1;
        }
    }
}
