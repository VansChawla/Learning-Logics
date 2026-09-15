class DeleteMidOfStack {
    
    // Recursive approach
    public void deleteMid(Stack<Integer> s) {
        if(s.isEmpty()) return;
        solRec(s, 0, s.size());
    }
    private void solRec(Stack<Integer> s, int count, int size){
        if(count == size / 2){
            s.pop();
            return;
        }
        
        int num = s.pop();
        
        solRec(s, count+1, size);
        
        s.push(num);
    }

    // Iterative approach
    public void deleteMid(Stack<Integer> s) {
        if(s.isEmpty())
            return;

        int midIndex = s.size()/2;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < midIndex; i++) {
            list.add(s.pop());
        }

        s.pop();
        
        for(int j=list.size()-1; j>=0; j--){
            s.push(list.get(j));
        }
    }
}