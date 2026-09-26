class ValidPalindromeII {
    
    // Solution 1: Using substring
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindrome(s.substring(l,r)) || isPalindrome(s.substring(l+1,r+1));
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // Solution 2: Using two pointer approach
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++; j--;
            } else return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++; j--;
            }
            else return false;
        }
        return true;
    }
}