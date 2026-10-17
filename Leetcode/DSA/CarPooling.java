class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int trip[] : trips){
            int cap = trip[0];
            int start = trip[1];
            int end = trip[2];

            map.put(start, map.getOrDefault(start, 0) + cap);
            map.put(end, map.getOrDefault(end, 0) - cap);
        }

        int passengers = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                passengers += entry.getValue();

                if(passengers > capacity){
                    return false;
                }
        }

        return true;
    }
}