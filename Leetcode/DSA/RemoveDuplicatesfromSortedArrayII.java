public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int result = 2;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] != nums[result - 2]) {
                nums[result] = nums[i];
                result++;
            }

        }
        return result;
    }
}