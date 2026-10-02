class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int l = 0;
        long count = 0;
        long sum = 0;

        for(int r=0; r<nums.length; r++){
            sum += nums[r];

            //score = sum*(r-l+1)
            while(sum*(r-l+1) >= k){
                sum -= nums[l];
                l++;
            }

            count += r-l+1;
        }

        return count;
    }
}