public class SumofAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n
        int totalSum = 0;

        for (int i = 0; i < totalSubsets; i++) {
            int currentXor = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentXor ^= nums[j];
                }
            }
            totalSum += currentXor;
        }

        return totalSum;
    }
}