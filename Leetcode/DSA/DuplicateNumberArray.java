class DuplicateNumberArray {

    // Using HashMap
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                return num;
            }
            map.put(num, 1);
        }


        return -1;
    }

    // Using Sorting
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }

        return nums.length;
    }
}