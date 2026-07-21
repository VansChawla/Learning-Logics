class MaxSumofDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        long result = 0;
        long currWindowSum = 0;

        HashSet<Integer> st = new HashSet<>();
        
        int i = 0;
        int j = 0;

        while (j < n) {
            // check if nums[j] is already present in current window nums[i..j]
            while (st.contains(nums[j])) {
                currWindowSum -= nums[i];
                st.remove(nums[i]);
                i++;
            }
            
            currWindowSum += nums[j];
            st.add(nums[j]);
            
            if (j - i + 1 == k) {
                result = Math.max(result, currWindowSum);
                
                currWindowSum -= nums[i];
                st.remove(nums[i]);
                i++;
            }
            
            j++;
        }

        return result;
    }
}