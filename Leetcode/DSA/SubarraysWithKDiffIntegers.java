class SubarraysWithKDiffIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // The core math trick: subtract atMost(k-1) from atMost(k)
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int l = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int r=0; r<nums.length; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) +1);

            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            
            count += r-l+1;
        }

        return count;
    }
}