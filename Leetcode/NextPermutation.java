public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the first decreasing element from the right
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If a decreasing element is found
        if (i >= 0) {
            // Step 2: Find the smallest element to the right of nums[i] that is larger than
            // nums[i]
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap the elements at i and j
            swap(nums, i, j);
        }

        // Step 4: Reverse the sub-array to the right of the element at i
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
