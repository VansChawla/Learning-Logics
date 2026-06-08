public class NumberofChangingKeys {
        public int countKeyChanges(String s) {
            String st = s.toLowerCase();
            int changeCount = 0;
    
            for(int i=0; i<s.length()-1; i++){
                if(st.charAt(i) != st.charAt(i+1)){
                    changeCount++;
                }
            }
    
            return changeCount;
    }
}
