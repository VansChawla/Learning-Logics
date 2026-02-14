class Solution {
    public int SubarrayProductLessThanK(int[] nums, int k) {
        // Edge case: Since all numbers are >= 1, if k is 0 or 1, 
        // no product can be strictly less than k.
        if (k <= 1) return 0;

        int currentProduct = 1;
        int count = 0;
        int left = 0;

        // Expand the window by moving the right pointer
        for (int right = 0; right < nums.length; right++) {
            currentProduct *= nums[right];

            // If the product is too large, shrink the window from the left
            while (currentProduct >= k) {
                currentProduct /= nums[left];
                left++;
            }

            // Add the number of valid subarrays ending at the 'right' pointer
            count += (right - left + 1);
        }

        return count;
    }
}