public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] length = new int[n]; // length[i] = length of longest ending in nums[i]
        int[] count = new int[n]; // count[i] = number of longest ending in nums[i]

        // Every element is a valid sequence of length 1 by itself
        for (int i = 0; i < n; i++) {
            length[i] = 1;
            count[i] = 1;
        }

        int maxLength = 1;

        // Outer loop: The number we are currently evaluating
        for (int i = 1; i < n; i++) {
            // Inner loop: Look back at all previous numbers
            for (int j = 0; j < i; j++) {

                // Is it an increasing sequence?
                if (nums[i] > nums[j]) {

                    // Case 1: We found a strictly longer sequence!
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j]; // Inherit the combinations
                    }
                    // Case 2: We found another sequence of the same max length!
                    else if (length[j] + 1 == length[i]) {
                        count[i] += count[j]; // Add these new combinations
                    }
                }
            }
            // Keep track of the absolute maximum length we've seen globally
            maxLength = Math.max(maxLength, length[i]);
        }

        // Finally, sum up all counts where the length matches our global maxLength
        int totalWays = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                totalWays += count[i];
            }
        }

        return totalWays;
    }
}
