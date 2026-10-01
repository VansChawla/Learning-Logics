class MaxSumofDistinctSubarraysWithLengthK {
    // Sliding window approach using HashMap
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        long sum = 0;
        long maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int dups = 0;

        for(int r=0; r<nums.length; r++){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);

            sum += nums[r];

            if(map.get(nums[r]) > 1){
                dups++;
            }

            if(r-l+1 == k){
                if(dups == 0){
                    maxSum = Math.max(maxSum, sum);
                }
                if (map.get(nums[l]) > 1) {
                    dups--;
                }
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                sum -= nums[l];
                l++;
            }

        }

        return maxSum;
    }

    // Sliding window approach using HashSet
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