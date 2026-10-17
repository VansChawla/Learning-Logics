class DataStreamAsDisjointIntervals {
    List<Integer> list;
    public SummaryRanges() {
        list = new ArrayList<>();
    }
    
    public void addNum(int value) {
        if(list.contains(value)) return;
        list.add(value);
    }
    
    public int[][] getIntervals() {
        if(list.size() == 0){
            return new int[][] {};
        }
        Collections.sort(list);

        Integer left = null;
        Integer right = null;

        List<int[]> res = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(left == null && right == null){
                left = list.get(i);
                right = list.get(i);
            }
            else if(list.get(i) == right + 1){
                right = list.get(i);
            }
            else {
                res.add(new int[] {
                    left, right
                });
                
                // Shifting left & right for the next interval
                left = list.get(i);
                right = list.get(i);
            }

        }
        res.add(new int[] {
            left, right
        });

        int[][] ans = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}