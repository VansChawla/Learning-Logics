public class MaxAvgSubarrayI {
    // Sliding Window
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.00;
        double max = -Double.MAX_VALUE;

        int n = nums.length;
        int l = 0;
        for(int r=0; r<n; r++){
            sum += nums[r];
            if(r-l+1 == k){
                max = Math.max(max, sum);
                sum -= nums[l];
                l++;
            }
        }

        return max/k;
    }

    // Old Solution
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxsum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxsum = Math.max(maxsum, sum);
        }

        return (double) maxsum / k;
    }
}
