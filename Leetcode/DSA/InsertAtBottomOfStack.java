class InsertAtBottomOfStack {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return st;
        }

        int num = st.pop();

        insertAtBottom(st, x);

        st.push(num);

        return st;
    }
}