class Solution {
    public int minScoreTriangulation(int[] values) {
        // int n = values.length;
        // int dp[][] = new int[n][n];

        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return mcmMem(values, 1, n-1, dp);

        return mcmTab(values);
    }

    //MEMOIZATION
    public int mcmMem(int[] arr, int i, int j, int dp[][]){
        if(i == j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1+cost2+cost3);
        }

        return dp[i][j] = ans;
    }

    //TABULATION
    public int mcmTab(int[] arr){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //Intialization
        for(int i=0; i<n; i++){
            dp[i][i] = 0; //diagonal elements
        }
        
        for(int len=2; len<=n-1; len++){
            for(int i=1; i<=n-len; i++){
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }

        return dp[1][n-1];
    }
}