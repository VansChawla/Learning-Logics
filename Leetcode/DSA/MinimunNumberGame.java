import java.util.Arrays;

public class MinimunNumberGame {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] result = new int[n];

        for (int i = 0; i < n; i = i + 2) {
            // int temp = nums[i]; // You can do it with swapping also.
            result[i] = nums[i + 1];
            result[i + 1] = nums[i];
        }

        return result;
    }
}
