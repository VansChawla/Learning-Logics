class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int k) {
        int n = s.length();
        int cost = 0;
        int len = 0;
        int l = 0;
        for(int r=0; r<n; r++){
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            
            while(cost > k){
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            len = Math.max(len, r-l+1);
        }
        return len;
    }
}