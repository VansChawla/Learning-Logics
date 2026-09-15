class ReverseAStack {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty())
            return;
        
        int num = st.pop();
        
        reverseStack(st);
        
        insertAtBottom(st, num);
    }
    
    public static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int num = st.pop();

        insertAtBottom(st, x);

        st.push(num);
    }
}
