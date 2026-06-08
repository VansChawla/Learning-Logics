import java.util.PriorityQueue;

public class MaximumProductAfterKincrements {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> numPQ = new PriorityQueue<>();
        int mod = 1000000007;

        for (int num : nums) // Add elements to PQ
            numPQ.offer(num);

        for (int i = 0; i < k; i++) {
            int minElement = numPQ.remove();
            minElement++; // Get the min ele and incre by 1

            numPQ.offer(minElement); // Add back to PQ
        }

        // Product
        long result = 1;
        while (!numPQ.isEmpty()) {
            result *= numPQ.poll();
            result %= mod;
        }

        return (int) result;
    }
}
