class InsertInterval {
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