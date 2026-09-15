class CelebrityProblem {
    public int celebrity(int mat[][]) {
        Stack<Integer> st = new Stack<>();
        
        int n = mat.length;
        for(int i=0; i<n; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            
            if(knows(mat, a, b)){
                st.push(b);
            } else {
                st.push(a);
            }
        }
        
        int ans = st.peek();
            
        int zeroCount = 0;
        for(int i=0; i<n; i++){
            if(mat[ans][i] == 0)
                zeroCount++;
        }
            
        if(zeroCount != n-1)
            return -1;
                
        int oneCount = 0;
        for(int i=0; i<n; i++){
            if(mat[i][ans] == 1)
                oneCount++;
        }
            
        if(oneCount != n)
            return -1;
                
        return ans;
    }
    
    private static boolean knows(int mat[][], int a, int b){
        if(mat[a][b] == 1)
            return true;
            
        return false;
    }
}