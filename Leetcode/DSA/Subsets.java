import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Backtracking approach to generate all subsets (Recursive)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalResult = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), finalResult);
        return finalResult;
    }

    public void findSubsets(int[] nums, int i, List<Integer> ans, List<List<Integer>> finalResult) {
        if (i == nums.length) {
            finalResult.add(new ArrayList<>(ans));
            return;
        }

        findSubsets(nums, i + 1, ans, finalResult); //NO

        ans.add(nums[i]);
        findSubsets(nums, i + 1, ans, finalResult); //YES
        
        // Backtrack: Remove the element we just added to reset the 'ans' 
        ans.remove(ans.size() - 1);
    }

    // Another approach using bit manipulation to generate all subsets
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
