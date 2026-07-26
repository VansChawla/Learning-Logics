class NMeetingsInOneRoom {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int act[][] = new int[s.length][3];
        
        for(int i=0; i<s.length; i++){
            act[i][0] = i+1;
            act[i][1] = s[i];
            act[i][2] = f[i];
        }
        
         Arrays.sort(act, (a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        result.add(act[0][0]);
        int lastEnd = act[0][2];
        for(int i=1; i<s.length; i++){
            if(act[i][1] > lastEnd){
                result.add(act[i][0]);
                lastEnd = act[i][2];
            }
        }
        
        Collections.sort(result);
        return result;
    }
}