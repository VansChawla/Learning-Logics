class MyCalendarI {
    // Line Sweep Algo
    class MyCalendar {
        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }
        
        public boolean book(int startTime, int endTime) {
            map.put(startTime, map.getOrDefault(startTime, 0) + 1);
            map.put(endTime, map.getOrDefault(endTime, 0) - 1);

            int bookings = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                bookings += entry.getValue();

                if(bookings > 1){
                    map.put(startTime, map.getOrDefault(startTime, 0) - 1);
                    map.put(endTime, map.getOrDefault(endTime, 0) + 1);

                    if(map.get(startTime) == 0){
                        map.remove(startTime);
                    }
                    if(map.get(endTime) == 0){
                        map.remove(endTime);
                    }

                    return false;
                }
            }
            return true;
        }
    }

    // Direct approach
    class MyCalendar {
        ArrayList<int[]> list;

        public MyCalendar() {
            list = new ArrayList<>();
        }
        
        public boolean book(int startTime, int endTime) {
            if(list.size() == 0){
                list.add(new int[] {
                    startTime,
                    endTime-1
                });
                return true;
            }

            for(int i=0; i<list.size(); i++){
                int s1 = list.get(i)[0];
                int e1 = list.get(i)[1];
                int s2 = startTime;
                int e2 = endTime-1;
                if(e2 >= s1 && e1 >= s2){
                    return false;
                }
            }

            list.add(new int[] {
                startTime,
                endTime-1
            });
        return true;
        }
    }
}