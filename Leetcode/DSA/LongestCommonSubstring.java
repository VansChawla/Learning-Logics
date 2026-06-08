class LongestCommonSubstring {
    private static int ans = 0;
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();   
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        ans = 0;
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        solnMem(s1, s2, n, m, dp);
        return ans;
        
        // return solnTab(s1, s2);
    }
    
    private int solnMem(String s1, String s2, int n, int m, int dp[][]){
        if(n == 0 || m == 0)
            return 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];
        
        solnMem(s1, s2, n - 1, m, dp);
        solnMem(s1, s2, n, m - 1, dp);
        
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            int curr = 1 + solnMem(s1, s2, n - 1, m - 1, dp);
            ans = Math.max(ans, curr);
            return dp[n][m] = curr;
        }
        
        return dp[n][m] = 0;
    }

    private int solnTab(String s1, String s2){
        int n = s1.length();   
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return ans;
    }
}