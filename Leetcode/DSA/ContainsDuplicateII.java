class ContainsDuplicateII {
    // Sliding window approach using HashMap
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        for(int r=0; r<nums.length; r++){

            if(map.containsKey(nums[r])){
                if(Math.abs(map.get(nums[r]) - r) <= k){
                    return true;
                } else {
                    map.remove(nums[l]);
                    l++;
                }
            }

            map.put(nums[r], r);
        }
        return false;
    }

    // Sliding window approach using HashSet
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int i = 0;
        for(int j=0; j<nums.length; j++){
            if(Math.abs(i-j) > k){
                set.remove(nums[i]);
                i++;
            }
            if(set.contains(nums[j]))
                return true;
            
            set.add(nums[j]);            
        }

        return false;
    }

    // Approach using HashMap
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            if(seen.containsKey(val) && i - seen.get(val) <= k){
                return true;
            }
            seen.put(val, i);
        }

        return false;

    }
}