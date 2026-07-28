import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // Approach 1: Using Recursion and Swapping - Striver's Approach
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    // Approach 2: Using Backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // We need a boolean array to keep track of which numbers we've already placed
        boolean[] used = new boolean[nums.length];
        
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentPerm, int[] nums, boolean[] used) {
        // Base Case: Our current permutation has all the numbers
        if (currentPerm.size() == nums.length) {
            // CRITICAL: We must make a copy of the current list before adding it to the result.
            // If we don't, subsequent backtracks will modify the list we just added!
            result.add(new ArrayList<>(currentPerm));
            return;
        }
        
        // Loop through all possible numbers we could add next
        for (int i = 0; i < nums.length; i++) {
            // If we already used this number in our current path, skip it
            if (used[i]) {
                continue;
            }
            
            // 1. CHOOSE: Mark the number as used and add it to our path
            used[i] = true;
            currentPerm.add(nums[i]);
            
            // 2. EXPLORE: Move to the next "slot" in the permutation
            backtrack(result, currentPerm, nums, used);
            
            // 3. UN-CHOOSE (Backtrack): Undo our choice so we can try the next number in the loop
            currentPerm.remove(currentPerm.size() - 1);
            used[i] = false;
        }
    }
}