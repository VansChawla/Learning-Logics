class CountPairsWhoseSumIsLessThanTarget {

    // Two pointer approach
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        Collections.sort(nums);

        int l = 0;
        int r = n-1;

        int count = 0;
        while(l < r){
            if(nums.get(l) + nums.get(r) < target){
                count += (r - l);
                l++;
            }
            else {
                r--;
            }
        }

        return count;
    }

    // Brute force approach
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        Collections.sort(nums);

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums.get(i) + nums.get(j) < target){
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}