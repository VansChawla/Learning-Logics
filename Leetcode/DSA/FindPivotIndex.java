public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        // Calculating total sum of nums array
        int totalSum = 0;
        for (int n : nums)
            totalSum += n;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {

            if (leftSum == totalSum - leftSum - nums[i])
                return i; // rightSum = leftSum

            leftSum += nums[i]; // Updating leftSum

        }
        return -1;
    }
}
