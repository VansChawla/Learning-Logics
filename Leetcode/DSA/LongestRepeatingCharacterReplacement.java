class LongestRepeatingCharacterReplacement {
    // Sliding Window With HashMap
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int l = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(); 

        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) +1);
            maxFreq = Math.max(maxFreq, map.get(rc));

            if((r-l+1) - maxFreq > k){
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) -1);
                if(map.get(lc) == 0) map.remove(lc);
                l++;
            }

            max = Math.max(max, r-l+1);
        }
        
        return max;
    }

    // Sliding Window With Char Array
    public int characterReplacement(String s, int k) {
        int maxLen = Integer.MIN_VALUE;
        int maxFreq = 0;
        int l = 0;
        int[] counter = new int[26];

        for(int r=0; r<s.length(); r++){
            char ch = s.charAt(r);
            counter[ch - 'A']++;
            maxFreq = Math.max(maxFreq, counter[ch - 'A']);

            // currTotalLen minus max char freq = kitne changes karne par maxlen milegi
            // agr vo nahi hai then shift left pointer  
            if((r-l+1) - maxFreq > k){
                counter[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}