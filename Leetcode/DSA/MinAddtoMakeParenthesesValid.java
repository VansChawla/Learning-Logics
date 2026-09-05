class MinAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int openBrac = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                st.push(ch);
            else if(st.size() > 0)
                st.pop();
            else 
                openBrac++;
        }

        return st.size() + openBrac;
    }
}