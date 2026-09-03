class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int[] counter = new int[26];

        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            counter[ch - 'a']++;
        }

        int i = 0, j = 0;
        boolean res = false;
        int k = s1.length();
        while(j < n){
            counter[s2.charAt(j) - 'a']--;

            if(j - i + 1 == k){
                if(allZero(counter)){
                    res = true;
                }

                counter[s2.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return res;

    }
    private boolean allZero(int[] counter){
        for(int i : counter){
            if(i != 0)
                return false;
        }
        return true;
    }
}