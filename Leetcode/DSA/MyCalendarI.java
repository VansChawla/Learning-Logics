class MyCalendarI {
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