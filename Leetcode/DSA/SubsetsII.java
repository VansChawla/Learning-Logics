import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> currentSubset = new ArrayList<>();
            boolean isIllegalSubset = false;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (j > 0 && nums[j] == nums[j - 1] && (i & (1 << (j - 1))) == 0) {
                        isIllegalSubset = true; // If subset is duplicate
                        break;
                    }
                    currentSubset.add(nums[j]);
                }
            }
            if (!isIllegalSubset) {
                result.add(currentSubset);
            }
        }

        return result;
    }
}
