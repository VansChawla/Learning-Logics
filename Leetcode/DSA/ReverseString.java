class ReverseString {
    // Using Stack
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s){
            stack.push(ch);
        }

        int i = 0;
        while(!stack.isEmpty()){
            s[i++] = stack.pop();
        }
    }

    // Using Two Pointers
    public void reverseString(char[] s) {
        int st = 0;
        int ed = s.length-1;

        while(st < ed){
            char temp = s[st];
            s[st] = s[ed];
            s[ed] = temp;
            st++; ed--;
        }
    }
}