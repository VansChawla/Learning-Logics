class MeetingRooms {
    static boolean canAttend(int[][] arr) {
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=1; i<arr.length; i++){
            int[] prev = arr[i - 1];
            int[] curr = arr[i];
            
            // s1 - prev[0];
            // e1 - prev[1];
            // s2 - curr[0];
            // e2 - curr[1];
            
            if(curr[0] < prev[1])
                return false;
                
        }
        
        return true;
    }
}