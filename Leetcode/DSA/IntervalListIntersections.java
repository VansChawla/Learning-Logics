class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>();

        int i = 0,
            j = 0;

        while(i < firstList.length && j < secondList.length){
            int s1 = firstList[i][0],
                e1 = firstList[i][1],
                s2 = secondList[j][0],
                e2 = secondList[j][1];

            if(e1 >= s2 && e2 >= s1){
                list.add(new int[] {
                    Math.max(s1, s2),
                    Math.min(e1, e2)
                });
            }

            if(e1 < e2){
                i++;
            }
            else {
                j++;
            }
        }

        int[][] ans = new int[list.size()][2];
        for(int k=0; k<list.size(); k++){
            ans[k] = list.get(k);
        }

        return ans;
    }
}