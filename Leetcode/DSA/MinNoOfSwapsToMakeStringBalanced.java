class MinNoOfSwapsToMakeStringBalanced {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '['){
                st.push(ch);
            } else if (st.size() > 0) {
                st.pop();
            }
            // else - st is empty - do nothing - continue;
        }

        return (st.size()+1) / 2;
    }
}