class MinOpstoMakeRotatedPalindromeI {
    public int minOperations(String s) {
        int n = s.length();
        int minTotalOperations = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            String rotated = s.substring(r) + s.substring(0, r);
            
            int currentCost = r; 
            
            int left = 0;
            int right = n - 1;
            
            while (left < right) {
                char c1 = rotated.charAt(left);
                char c2 = rotated.charAt(right);
                
                if (c1 != c2) {
                    int cost1 = (c2 - c1 + 26) % 26;
                    int cost2 = (c1 - c2 + 26) % 26;
                    
                    currentCost += Math.min(cost1, cost2);
                }
                left++;
                right--;
            }
            
            minTotalOperations = Math.min(minTotalOperations, currentCost);
        }
        
        return minTotalOperations;

    }
}