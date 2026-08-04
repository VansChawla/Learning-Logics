class NextSmallestElement {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> l = new ArrayList<>();

        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && s.peek() >= arr[i]){
                s.pop();
            }

            if(!s.isEmpty()){
                l.add(s.peek());
            } else {
                l.add(-1);
            }

            s.push(arr[i]);
        }
        
        Collections.reverse(l); 
        return l;
    }
}