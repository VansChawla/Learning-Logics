public class MaxSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max_str_sum = Integer.MIN_VALUE;
        int min_str_sum = Integer.MAX_VALUE;
        int arr_sum = 0;

        int temp_max = 0;
        int temp_min = 0;

        for (int i = 0; i < n; i++) {
            arr_sum += nums[i];

            temp_max += nums[i];
            max_str_sum = max_str_sum < temp_max ? temp_max : max_str_sum;
            temp_max = temp_max < 0 ? 0 : temp_max;

            temp_min += nums[i];
            min_str_sum = min_str_sum > temp_min ? temp_min : min_str_sum;
            temp_min = temp_min > 0 ? 0 : temp_min;
        }

        if (arr_sum == min_str_sum)
            return max_str_sum;

        return Math.max(max_str_sum, (arr_sum - min_str_sum));
    }
}
