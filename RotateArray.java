class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[]nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

//Right rotation happens here
//[1,2,3,4,5,6,7] - I/O
//n = 7, k = 3

//Trick by revering the array
//[7,6,5,4,3,2,1] - Reverse whole array
//[5,6,7,4,3,2,1] - then reverse first half (3 elements of starting)

//[5,6,7,1,2,3,4] - Result O/P 