class DuplicateNumberArray {

    // Using Floyd's Tortoise and Hare (Cycle Detection) - Optimal Solution
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

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