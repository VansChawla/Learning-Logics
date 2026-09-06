import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // New Solution - Sliding Window Approach
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int len = 0;
        int l = 0;
        for(int r=0; r<s.length(); r++){
            char ch = s.charAt(r);

            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(ch);

            len = Math.max(len, r-l+1);
        }

        return len;
    }

    // Old 
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        
        return maxLength;
    }
}
