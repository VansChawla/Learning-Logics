class ClimbingStairs {
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        return mainLogic(n, ways);        
    }
    private int mainLogic(int n, int ways[]){
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(ways[n] != -1)
            return ways[n];

        ways[n] = mainLogic(n-1, ways) + mainLogic(n-2, ways);
        return ways[n];
    }
}