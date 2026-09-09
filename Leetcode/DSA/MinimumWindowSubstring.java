class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> tarMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tarMap.put(ch, tarMap.getOrDefault(ch, 0)+1);
        }
        int required = tarMap.size();

        HashMap<Character, Integer> winMap = new HashMap<>();
        int l = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int startI = 0;

        for(int r=0; r<s.length(); r++){
            char ch = s.charAt(r);

            winMap.put(ch, winMap.getOrDefault(ch, 0)+1);
            
            if (tarMap.containsKey(ch) && 
                winMap.get(ch).equals(tarMap.get(ch))) formed++;

            while(formed == required){
                if (r-l+1 < minLen) {
                    minLen = r-l+1;
                    startI = l;
                }

                char lch = s.charAt(l);
                winMap.put(lch, winMap.get(lch)-1);

                if (tarMap.containsKey(lch) && 
                    winMap.get(lch) < tarMap.get(lch)) formed--;
                l++;
            }   
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startI, startI + minLen);
    }
}