class MaxNumberOfVowelsInSubstringOfGivenLen {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowels = 0;
        int max = 0;
        int l = 0;
        
        for(int r=0; r<n; r++){
            char ch = s.charAt(r);
            if(isVowel(ch)) vowels++;

            if(r-l+1 == k){
                max = Math.max(vowels, max);
                char c = s.charAt(l);
                if(isVowel(c)) vowels--;
                l++;
            }
        }

        return max;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}