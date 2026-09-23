class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentNum = nums[i % n];

            while (!s.isEmpty() && s.peek() <= currentNum) {
                s.pop();
            }

            if (i < n) {
                if (!s.isEmpty()) {
                    result[i] = s.peek();
                } else {
                    result[i] = -1;
                }
            }
            s.push(currentNum);
        }

        return result;
    }
}
