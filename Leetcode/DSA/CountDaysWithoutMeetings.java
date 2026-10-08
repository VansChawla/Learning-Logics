class CountDaysWithoutMeetings {
    // Approach 1: Without merging intervals
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        int gap = 0;

        int maxEnd = meetings[0][1];

        for(int i=1; i<meetings.length; i++){
            if(meetings[i][0] > maxEnd){
                gap += meetings[i][0] - maxEnd - 1;
            }

            maxEnd = Math.max(maxEnd, meetings[i][1]);
        }

        gap += meetings[0][0] - 1;
        gap += days - maxEnd;

        return gap;
    }

    // Approach 2: With merging intervals
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        // Merge Intervals first
        list.add(meetings[0]);

        for(int i=1; i<meetings.length; i++){
            int[] prev = list.get(list.size()-1);
            int[] curr = meetings[i];

            if(curr[0] <= prev[1]){
                //merge
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
            else {
                list.add(meetings[i]);
            }
        }

        int gap = 0;

        // Gap calculation
        for(int i=1; i<list.size(); i++){
            gap += (list.get(i)[0] - list.get(i-1)[1]) - 1;
        }

        gap += list.get(0)[0] - 1;
        gap += days - list.get(list.size()-1)[1];

        return gap;
    }
}