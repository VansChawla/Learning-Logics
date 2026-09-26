public class ValidPalindrome {
    //Solution 1: Two pointer approach
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    //Solution 2: Clean string and check
    public boolean isPalindrome(String s) {
        String cs = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // clean string
        int n = cs.length();

        if (cs.length() == 1)
            return true;

        for (int i = 0; i < n; i++) {
            if (cs.charAt(i) != cs.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
