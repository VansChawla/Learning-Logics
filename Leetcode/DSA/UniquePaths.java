class UniquePaths {
    public int uniquePaths(int m, int n) {
        return uniquePathsRec(m-1, n-1); //RECURSIVE APPROACH

        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        return uniquePathsMem(m-1, n-1, dp); //MEMOIZATION DP

        return uniquePathsTab(m, n); //TABULATION DP
    }

    private int uniquePathsRec(int i, int j) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        int up = uniquePathsRec(i-1, j);
        int left = uniquePathsRec(i, j-1);

        return up + left;
    }

    private int uniquePathsMem(int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = uniquePathsMem(i-1, j, dp);
        int left = uniquePathsMem(i, j-1, dp);

        return dp[i][j] = up + left;
    }

    private int uniquePathsTab(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}