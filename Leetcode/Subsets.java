import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> currentSubset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSubset.add(nums[j]);
                }
            }
            result.add(currentSubset);
        }

        return result;
    }
}
