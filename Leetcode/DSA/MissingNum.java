import java.util.Arrays;

public class MissingNum {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }

        return nums.length;
    }
}
