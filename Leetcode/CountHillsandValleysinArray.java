class CountHillsandValleysinArray {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;

        int uniqueCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        for(int i=1; i<uniqueCount-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1] ||
                nums[i-1] > nums[i] && nums[i] < nums[i+1]){
                count++;
            }
        }

        return count;
    }
}