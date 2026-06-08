public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // BINARY SEARCH O(logn)
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return left;
    }
}
