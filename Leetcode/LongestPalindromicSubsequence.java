public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String s_reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int dp[][] = new int[n+1][n+1];

        //Tabulation DP
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(s.charAt(i-1) == s_reversed.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][n];
    }
}