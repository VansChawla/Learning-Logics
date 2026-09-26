class TwoSum{
    // Two Pointer Solution
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] sorted = new int[n][2];

        for(int i=0; i<n; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            int sum = sorted[l][0] + sorted[r][0];

            if(sum == target){
                return new int[]{sorted[l][1], sorted[r][1]};
            }
            else if (sum < target){
                l++;
            }
            else {
                r--;
            }
        }
        return new int[]{};
    }

    // HashMap Solution
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){ //Search remaining in the hashtable
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; //No Solution Found
    }

    // Brute Force Solution
    public int[] twoSum(int[] nums, int target) {
        int[] newArr = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    newArr[0] = i;
                    newArr[1] = j;
                }
            }
        }
        return newArr;
    }
}