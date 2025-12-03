import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {
        Queue<Integer> queue;
    
        public RecentCounter() {
            queue = new LinkedList<>();
        }
    
        public int ping(int t) {
            queue.add(t);
    
    
            //A valid range is [t-3000, t]
            //So any timestamp < t-3000 is invalid
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
    
            //The size of the queue is the number of recent calls
            return queue.size();
        }
        
}
