class LengthOfLongestSubarrayWithAtMostKFreq {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int len = 0;
        int n = nums.length;

        for(int r=0; r<n; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) +1);

            while(l < r && map.get(nums[r]) > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }

            len = Math.max(len, r-l+1);
        }

        return len;
    }
}