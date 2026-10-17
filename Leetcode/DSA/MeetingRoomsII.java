class MeetingRoomsII {
    public int minMeetingRooms(int[] start, int[] end) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<start.length; i++){
            map.put(start[i], map.getOrDefault(start[i], 0) + 1);
            map.put(end[i], map.getOrDefault(end[i], 0) - 1);
        }
        
        int rooms = 0;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            rooms += entry.getValue();
            max = Math.max(max, rooms);
        }
        
        return max;
    }
}
