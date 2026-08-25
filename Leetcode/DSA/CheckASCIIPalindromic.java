class CheckASCIIPalindromic {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            String rawBinary = Integer.toBinaryString(ch);
            String paddedBinary = String.format("%8s", rawBinary).replace(' ', '0');
            sb.append(paddedBinary);
        }

        //Palindrome Check
        int i = 0, j = sb.length()-1;
        while(i <= j){
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++; j--;
        }
        
        return true;
    }
}