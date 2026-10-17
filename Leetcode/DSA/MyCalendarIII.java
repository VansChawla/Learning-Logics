public class MyCalendarIII {
    class MyCalendarThree {
        TreeMap<Integer, Integer> map;
        public MyCalendarThree() {
            map = new TreeMap<>();
        }
        
        public int book(int startTime, int endTime) {
            int max = Integer.MIN_VALUE;
            int bookings = 0;
            
            map.put(startTime, map.getOrDefault(startTime, 0) + 1);
            map.put(endTime, map.getOrDefault(endTime, 0) - 1);

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                bookings += entry.getValue();

                max = Math.max(max, bookings);
            }

            return max;
        }
    }
}
