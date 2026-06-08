public class StringCompressionLeetcode {
    // LOGICALLY CORRECT, BUT FAILS LEETCODE CONSTRAINTS
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            
            sb.append(chars[i]); // Add character
            
            int count = j - i;
            if (count > 1) {
                sb.append(count); // Add count
            }
            
            i = j;
        }
        
        // NOW THE PROBLEM: 
        // We have the answer in 'sb', but we need to put it back into 'chars'.
        
        for (int k = 0; k < sb.length(); k++) {
            chars[k] = sb.charAt(k);
        }
        
        return sb.length();
    }
}
