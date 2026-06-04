class NthCatalanNumber {
    public static int findCatalan(int n) {
        
        return catalanTab(n);
        
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // return catalanMem(n, dp);
    }
    
    //O(n^2)
    //Efficient solution using tabulation
    public static int catalanTab(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        
        return dp[n];
    }
    
    //Brute force solution using memoization
    public static int catalanMem(int n, int dp[]){
        if(n==0 || n==1)  return 1;
        
        if(dp[n] != -1) return dp[n];
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
        }
        
        return ans;
    }
}
