public class StackUsingArray {
    class myStack {
    int top;
    int st[];

    public myStack(int n) {
        top = -1;
        st = new int[n];
    }

    public boolean isEmpty() {
        if(top == -1) return true;
        else return false;
    }

    public boolean isFull() {
        if(top >= st.length-1) return true;
        else return false;
    }

    public void push(int x) {
        if(!isFull()){
            top = top+1;
            st[top] = x;
        }
    }

    public void pop() {
        if(!isEmpty())
            top = top-1;
    }

    public int peek() {
        if(isEmpty())
            return -1;
        return st[top];
    }
}
}
