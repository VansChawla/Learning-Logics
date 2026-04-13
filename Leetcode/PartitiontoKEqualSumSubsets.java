public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 1. Math Check: Can we evenly divide the sum?
        if (totalSum % k != 0)
            return false;

        int target = totalSum / k;

        // 2. Sort the array. Java sorts primitives ascending.
        // We will just iterate backward to simulate descending order.
        Arrays.sort(nums);

        int n = nums.length;
        // If the single largest number is strictly greater than the target, it's
        // impossible.
        if (nums[n - 1] > target)
            return false;

        boolean[] used = new boolean[n];

        // Start backtracking from the end of the array (largest numbers)
        return backtrack(nums, n - 1, k, 0, target, used);
    }

    private boolean backtrack(int[] nums, int startIndex, int k, int currentSum, int target, boolean[] used) {
        // Base Case: If we have successfully built k-1 buckets, the remaining
        // unused numbers will mathematically perfectly sum to the last bucket!
        if (k == 1)
            return true;

        // If our current bucket is full, start the next bucket!
        // Notice we reset currentSum to 0, and start searching from the very end of the
        // array again.
        if (currentSum == target) {
            return backtrack(nums, nums.length - 1, k - 1, 0, target, used);
        }

        // Try placing unused numbers into the current bucket
        for (int i = startIndex; i >= 0; i--) {
            // PRUNING 1: Skip if already used, or if adding it overflows the bucket
            if (used[i] || currentSum + nums[i] > target) {
                continue;
            }

            // CHOOSE
            used[i] = true;

            // EXPLORE
            // We pass 'i - 1' because we don't want to reuse the same number,
            // and we want to keep checking smaller numbers for this same bucket.
            if (backtrack(nums, i - 1, k, currentSum + nums[i], target, used)) {
                return true;
            }

            // UN-CHOOSE (Backtrack)
            used[i] = false;

            // --- CRITICAL PRUNING STEP ---
            // If the current bucket is empty, and the largest available number
            // we just tried couldn't lead to a solution, then NO solution exists.
            // Why? Because this massive number HAS to go into *some* bucket eventually.
            // If it can't even start its own bucket successfully, the whole board is
            // unsolvable.
            if (currentSum == 0) {
                return false;
            }
        }

        return false;
    }
}
