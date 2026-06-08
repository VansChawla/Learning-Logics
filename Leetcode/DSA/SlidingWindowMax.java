class SlidingWindowMax {
    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt((Pair e) -> e.value).reversed()
        );

        for(int i=0; i<k; i++){
            pq.add(new Pair(nums[i], i));
        }

        res[0] = pq.peek().value;

        for(int i=k; i<nums.length; i++){
            while(pq.size() > 0 && pq.peek().index <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(nums[i], i));
            res[i-k+1] = pq.peek().value;
        }

        return res;
    }
}




// if (nums == null || nums.length == 0 || k == 0)
//             return new int[0];

//         int[] result = new int[nums.length - k + 1];
//         int resultIndex = 0;

//         Deque<Integer>    deque = new ArrayDeque<>();

//         for(int i=0; i<nums.length; i++){
//             if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
//                 deque.pollFirst();
//             }

//             while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
//                 deque.pollLast();
//             }

//             deque.offerLast(i);

//             if (i >= k - 1) {
//                 result[resultIndex] = nums[deque.peekFirst()];
//                 resultIndex++;
//             }
//         }

//         return result;