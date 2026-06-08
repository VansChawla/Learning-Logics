public class MinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If array is already sorted
            if (nums[start] <= nums[end]) {
                answer = Math.min(answer, nums[start]);
                break;
            }

            // Eiminate left half and store min
            if (nums[start] <= nums[mid]) {
                answer = Math.min(answer, nums[start]);
                start = mid + 1;
            }
            // Eliminate right half and store min which is mid
            else {
                answer = Math.min(answer, nums[mid]);
                end = mid - 1;
            }
        }
        return answer;
    }
}
