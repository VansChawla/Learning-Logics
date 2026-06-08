class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reachable = 0;

        for(int i=0; i<nums.length; i++){
            if(i > reachable){
                return false;
            }
            
            reachable = Math.max(reachable, i+nums[i]);

            if (reachable >=  n-1){
                return true;
            }
        }

        return true;
    }

    // Tabulation DP approach
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean dp[] = new boolean[n];
        dp[n-1] = true;

        for(int i=n-2; i>=0; i--){
            int steps = nums[i];
            boolean ans = false;
            for(int j=i+1; j<=i+steps && j<n; j++){
                if(dp[j]){
                    ans = true;
                    break;
                }
            }
            dp[i] = ans;
        }

        return dp[0];
    }
}