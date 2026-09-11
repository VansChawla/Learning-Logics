import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
    // Stores the smaller half of the numbers (Max-Heap)
    private PriorityQueue<Integer> small;
    // Stores the larger half of the numbers (Min-Heap)
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}

}