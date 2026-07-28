import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

    // Approach 1: Backtracking with skipping duplicates - Shradha's approach
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalResult = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), finalResult);
        return finalResult;
    }

    public void findSubsets(int[] nums, int i, List<Integer> ans, List<List<Integer>> finalResult) {
        if (i == nums.length) {
            finalResult.add(new ArrayList<>(ans));
            return;
        }

        //INCLUDE
        ans.add(nums[i]);
        findSubsets(nums, i + 1, ans, finalResult);

        ans.remove(ans.size() - 1); //BACKTRACK

        int idx = i+1;
        while(idx < nums.length && nums[idx] == nums[idx-1]) idx++;

        //EXCLUDE
        findSubsets(nums, idx, ans, finalResult);
    }


    // Approach 2: Backtracking with HashSet to avoid duplicates
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalResult = new ArrayList<>();
        Set<List<Integer>> setOfLists = new HashSet<>();
        findSubsets(nums, 0, new ArrayList<>(), finalResult, setOfLists);
        return finalResult;
    }

    public void findSubsets(int[] nums, int i, List<Integer> ans, List<List<Integer>> finalResult,
                                Set<List<Integer>> setOfLists) {
        if (i == nums.length) {
            if(!setOfLists.contains(ans)){
                setOfLists.add(new ArrayList<>(ans));
                finalResult.add(new ArrayList<>(ans));
            }
            return;
        }

        findSubsets(nums, i + 1, ans, finalResult, setOfLists); //NO

        ans.add(nums[i]);
        findSubsets(nums, i + 1, ans, finalResult, setOfLists); //YES
        
        ans.remove(ans.size() - 1); //BACKTRACK
    }


    // Approach 3: Bit Manipulation
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
