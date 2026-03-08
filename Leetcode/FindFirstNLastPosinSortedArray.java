public class FindFirstNLastPosinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, true);
        if (left == -1) {
            return new int[] { -1, -1 };
        }
        int right = findBound(nums, target, false);
        return new int[] { left, right };
    }

    private int findBound(int[] nums, int target, boolean findFirst) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                if (findFirst) {
                    high = mid - 1; // Continue searching left for the very first occurrence
                } else {
                    low = mid + 1; // Continue searching right for the very last occurrence
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
