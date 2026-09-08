class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxLen = Integer.MIN_VALUE;
        int maxFreq = 0;
        int l = 0;
        int[] counter = new int[26];

        for(int r=0; r<s.length(); r++){
            char ch = s.charAt(r);
            counter[ch - 'A']++;
            maxFreq = Math.max(maxFreq, counter[ch - 'A']);

            if((r-l+1) - maxFreq > k){
                counter[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}