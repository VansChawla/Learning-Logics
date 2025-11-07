public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lPtr = 0;

        for (int rPtr = 0; rPtr < nums.length; rPtr++) {
            if (nums[rPtr] != 0) {
                int temp = nums[rPtr];
                nums[rPtr] = nums[lPtr];
                nums[lPtr] = temp;
                lPtr++;
            }
        }
    }
}
