class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }

        if(total%2 != 0)
            return false;

        int target = total / 2;

        // Boolean dp[][] = new Boolean[n+1][target+1];
        // return solveMem(0, nums, n, target, dp);

        // return solveTab(n, nums, total);

        return solveTabOtm(n, nums, total);
    }

    private boolean solveTabOtm(int n, int[] arr, int total){
        int targetSum = total / 2;
    
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true; // Base case

        for (int index = n - 1; index >= 0; index--) {
            for (int target = targetSum; target >= 1; target--) {
                boolean include = false;
                if (target - arr[index] >= 0) {
                    include = dp[target - arr[index]];
                }
                boolean exclude = dp[target];

                dp[target] = include || exclude;
            }
        }
        return dp[targetSum];
    }

    private boolean solveTab(int n, int[] arr, int total){
        int targetSum = total / 2;
        boolean dp[][] = new boolean[n+1][targetSum+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int index = n-1; index >= 0; index--){
            for(int target = 0; target <= targetSum; target++){
                boolean include = false;
                if(target - arr[index] >= 0)
                    include = dp[index+1][target - arr[index]];
                boolean exclude = dp[index+1][target];

                dp[index][target] = include || exclude;
            }
        }

        return dp[0][targetSum];
    }

    private boolean solveMem(int index, int[] arr, int n, int target, Boolean[][] dp){
        if(index >= n || target < 0)
            return false;
        if(target == 0)
            return true;

        if(dp[index][target] != null)
            return dp[index][target];

        boolean include = solveMem(index+1, arr, n, target-arr[index], dp);   
        boolean exclude = solveMem(index+1, arr, n, target-0, dp);   

        return dp[index][target] = include || exclude;
    }
}