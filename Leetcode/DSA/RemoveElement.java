class Solution {
    // Approach 1: Using two pointers and swapping elements
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == val) count++;
        }

        int k = n-count;
        int i = 0;
        int j = n-1;
        while(i <= j){
            if(nums[i] == val && nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            } else if(nums[i] != val){
                i++;
            } else if(nums[j] == val){
                j--;
            }
        }

        return k;
    }

    // Approach 2: Using two pointers and overwriting elements
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
}