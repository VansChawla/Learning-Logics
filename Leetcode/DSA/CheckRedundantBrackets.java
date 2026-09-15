class CheckRedundantBrackets {
    public boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            }
            else if(ch == ')' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (st.peek() == '(') {
                    return true;
                }
                                
                if(ch == ')'){
                    boolean isRedundant = false;
                    while(!st.isEmpty() && st.peek() != '('){
                        char top = st.peek();
                        if(top == '+' || top == '-' || top == '*' || top == '/'){
                            isRedundant = true;
                        }
                        st.pop();
                    }
                    
                    if(!st.isEmpty()) st.pop();
                    
                    if(!isRedundant)
                        return true;
                }
            }
        }
        
        return false;
    }
}
