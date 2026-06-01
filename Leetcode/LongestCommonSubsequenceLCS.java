class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return solveTab(text1, text2);

        // int n = text1.length();
        // int m = text2.length();
        // int dp[][] = new int[n+1][m+1];
        // for(int i=0; i<n+1; i++){
        //     for(int j=0; j<m+1; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return solveMem(text1, text2, n, m, dp);

        // return solveRec(text1, text2, n, m);
    }

    private int solveTab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i][j-1];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    private int solveMem(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0)
            return 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = solveMem(str1, str2, n-1, m-1, dp) + 1;
        } else {
            int ans1 = solveMem(str1, str2, n-1, m, dp);
            int ans2 = solveMem(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    private int solveRec(String str1, String str2, int n, int m){
        if(n == 0 || m == 0)
            return 0;
        
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return solveRec(str1, str2, n-1, m-1) + 1;
        } else {
            int ans1 = solveRec(str1, str2, n-1, m);
            int ans2 = solveRec(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }
}