class InsertInterval {
    // Approach 1 - Using while loop
    public int[][] insert(int[][] arr, int[] newArr) {
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        //First pushing non-overlapping intervals
        while(i < arr.length && newArr[0] > arr[i][1]){
            ans.add(arr[i]);
            i++;
        }

        // s1 - arr[i][0];
        // e1 - arr[i][1];
        // s2 - newArr[0];
        // e2 - newArr[1];
        // Overlapping cond - (e2 >= s1 && e1 >= s2)
        // Overlapping cond met with newInterval
        while(i < arr.length && (newArr[1] >= arr[i][0] && arr[i][1] >= newArr[0]) ){
            newArr[0] = Math.min(arr[i][0], newArr[0]);
            newArr[1] = Math.max(arr[i][1], newArr[1]);
            i++;
        }

        ans.add(newArr);

        // Pushing remaining intervals
        while(i < arr.length){
            ans.add(arr[i]);
            i++;
        }

        int[][] res = new int[ans.size()][2];
        for(int j=0; j<ans.size(); j++){
            res[j] = ans.get(j);
        }

        return res;
    }

    // Approach 2 - Using for loop
    public int[][] insert(int[][] arr, int[] newArr) {
        List<int[]> ans = new ArrayList<>();

        int newStart = newArr[0];
        int newEnd = newArr[1];
        boolean inserted = false;

        for(int i=0; i<arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(end < newStart) {
                ans.add(new int[]{start, end});
            }
            else if(start <= newEnd){
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
            else if(start > newEnd){
                if (!inserted) {
                    ans.add(new int[]{newStart, newEnd});
                    inserted = true;
                }
                ans.add(new int[]{start, end});
            }
        }

        if (!inserted) {
            ans.add(new int[]{newStart, newEnd});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}