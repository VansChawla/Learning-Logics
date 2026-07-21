class ThreeSumArray {

        //Optimised Approach
        public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length-2; i++){
             // Optimization 1: If the smallest remaining element is > 0, three positive numbers cannot sum to 0
            if (nums[i] > 0) break;

            // Optimization 2: Skip duplicate elements for the first element 'i'
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //Two sum approach
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Optimization 3: Skip duplicate elements for 'left' and 'right' pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++; right--;
                } else if(sum < 0)
                    left++;
                else 
                    right--;
                
            }
        }
        return new ArrayList<>(result);
    }

    //Little less optimised approach
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        //Now fix the first element and find the other two elements
        for(int i = 0; i < nums.length-2; i++){

            //Find the other two elements using Two sum approach
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0){

                    //Add the set, and move to find other triplets
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(sum < 0)
                    left++;
                else 
                    right--;
                
            }
        }
        return new ArrayList<>(result);
    }
}