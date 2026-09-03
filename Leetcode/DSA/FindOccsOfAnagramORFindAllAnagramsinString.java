class FindOccsOfAnagramORFindAllAnagramsinString {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();

        int[] counter = new int[26];

        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);

            counter[ch - 'a']++;
        }

        int i=0, j=0;
        List<Integer> res = new ArrayList<>();
        int k = p.length();
        while(j < n){
            counter[s.charAt(j) - 'a']--;

            if(j - i + 1 == k){
                if(allZero(counter)){
                    res.add(i);
                }

                counter[s.charAt(i) - 'a']++;
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