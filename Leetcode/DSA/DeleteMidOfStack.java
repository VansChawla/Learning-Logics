class DeleteMidOfStack {
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