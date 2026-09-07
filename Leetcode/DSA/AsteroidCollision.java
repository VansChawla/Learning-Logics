class AsteroidCollision {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 0){
                s.push(arr[i]);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(arr[i])) {
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() > 0 && s.peek() == Math.abs(arr[i])) {
                    s.pop(); 
                } 
                else if (!s.isEmpty() && s.peek() > 0 && s.peek() > Math.abs(arr[i])) {
                    continue; 
                } 
                else {
                    s.push(arr[i]);
                }
            }
        }

        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }

        return res;
    }
}