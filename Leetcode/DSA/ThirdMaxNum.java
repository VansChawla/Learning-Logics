class ThirdMaxNum {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }
            
            pq.add(num);
            seen.add(num);
            
            if (pq.size() > 3) {
                int removed = pq.poll();
                seen.remove(removed);
            }
        }
        
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
