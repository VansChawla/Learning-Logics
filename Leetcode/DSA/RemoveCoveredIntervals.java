class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        list.add(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int[] prev = list.get(list.size()-1);
            int[] curr = intervals[i];

            int s1 = prev[0];
            int e1 = prev[1];
            int s2 = curr[0];
            int e2 = curr[1];

            // Containted Interval CondN
            if((s2 >= s1 && e2 <= e1) || (s1 >= s2 && e1 <= e2)){
                prev[0] = Math.min(s1, s2);
                prev[1] = Math.max(e1, e2);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.size();
    }
}