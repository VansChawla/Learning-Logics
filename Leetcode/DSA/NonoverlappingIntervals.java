class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Arrays.sort(intervals, Comparator.comparingDouble(o -> o[1])); //SLOW
        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));    //FAST
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));    //FASTEST

        int result = 0;
        int intervalEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervalEnd){
                result++;
            } else {
                intervalEnd = intervals[i][1];
            }
        } 

        return result;
    }
}