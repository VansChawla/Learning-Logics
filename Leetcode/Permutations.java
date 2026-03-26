import java.util.ArrayList;
import java.util.List;
public class Permutations {

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