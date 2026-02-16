class Solution {
    public boolean PowerOfTwo(int n) {

        //Solution one with bit manipulations
        if(n > 0 && (n & n-1) == 0) return true;
        return false;

        //Solution two
        for(int i=0 ;; i++){
            if(Math.pow(2,i) == n)
                return true;
            else if(Math.pow(2,i) > n)
                return false;
        }
        
    }
}