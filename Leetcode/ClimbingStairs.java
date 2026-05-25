class ClimbingStairs {
    //TABULATION
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            if(i == 1)
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //MEMOIZATION
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        return mainLogic(n, ways);        
    }
    private int mainLogic(int n, int ways[]){
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(ways[n] != -1)
            return ways[n];

        ways[n] = mainLogic(n-1, ways) + mainLogic(n-2, ways);
        return ways[n];
    }
}