public class NumberofSubstringsContainingAllThreeChars {
        public int numberOfSubstrings(String s) {
            int left = 0;
            int totalSubstrings = 0;
            int n = s.length();
            // Array to store counts of 'a', 'b', and 'c'
            int[] count = new int[3];
    
            for (int right = 0; right < n; right++) {
                // Include current character in the count
                count[s.charAt(right) - 'a']++;
    
                // While the current window is valid (contains 'a', 'b', and 'c')
                while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                    // If s[left...right] is valid, then all substrings starting at 'left'
                    // and ending at any index from 'right' to 'n-1' are valid.
                    totalSubstrings += (n - right);
    
                    // Try to shrink the window from the left
                    count[s.charAt(left) - 'a']--;
                    left++;
                }
            }
    
            return totalSubstrings;
        }
}
