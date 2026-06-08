public class LongestPalindromicSubstringDP {
    //DP (Tabulation / Bottom-Up) solution with O(n^2) time complexity and O(n^2) space complexity
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int maxLen = 1;
        int start = 0;
        
        // Base case: All single-character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Base case: Check two-character substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (maxLen < 2) {
                    start = i;
                    maxLen = 2;
                }
            }
        }
        
        // Check for substrings of length 3 and greater
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index
                
                // If boundary characters match, check the remaining inner substring
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}