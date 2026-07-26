class MinNumberofFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if(!isValid(croakOfFrogs)) return -1;
        int frogs = 0;
        int maxFrogs = 0;

        for(int i=0; i<croakOfFrogs.length(); i++){
            char c = croakOfFrogs.charAt(i);

            if(c == 'c'){
                frogs++;
                maxFrogs = Math.max(maxFrogs, frogs);
            }
            else if (c == 'k'){
                frogs--;
            }
        }

        return maxFrogs;
    }
    private boolean isValid(String croakOfFrogs) {
    int c = 0, r = 0, o = 0, a = 0, k = 0;
    
    for (int i = 0; i < croakOfFrogs.length(); i++) {
        char ch = croakOfFrogs.charAt(i);
        
        // 1. Count each letter as it appears sequentially
        if (ch == 'c') c++;
        else if (ch == 'r') r++;
        else if (ch == 'o') o++;
        else if (ch == 'a') a++;
        else if (ch == 'k') k++;
        else return false; // Contains an invalid character
        
        // 2. Continuous Order Check: A letter cannot outnumber its predecessor.
        // E.g., You cannot have an 'o' without a preceding 'r' and 'c'.
        if (!(c >= r && r >= o && o >= a && a >= k)) {
            return false;
        }
    }
    
    // 3. Final Completion Check: Frogs must finish all 5 letters.
    // If the counts are equal, every "croak" was fully completed.
    return (c == r && r == o && o == a && a == k);
}
}