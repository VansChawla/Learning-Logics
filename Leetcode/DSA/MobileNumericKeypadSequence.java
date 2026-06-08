class MobileNumericKeypadSequence {
    String printSequence(String S) {
        String str[]
            = { "2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999" };
                
        String output = "";        
        
        for(int i=0; i<S.length(); i++){
            
            if(S.charAt(i) == ' '){
                output += "0";
            }
            
            else {
                int index = S.charAt(i) - 'A';
                output += str[index];
            }
        }
        
        return output;
    }
}