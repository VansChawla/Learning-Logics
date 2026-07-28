import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    //Striver's approach
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findAllCombSums(candidates, 0, ans, new ArrayList<>(), target);
        return ans;
    }

    private void findAllCombSums(int[] arr, int i, List<List<Integer>> ans, List<Integer> currSum, int target){
        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(currSum));
            }
            return;
        }

        if(arr[i] <= target){
            currSum.add(arr[i]);
            findAllCombSums(arr, i, ans, currSum, target-arr[i]);
            currSum.remove(currSum.size()-1);
        }
        findAllCombSums(arr, i+1, ans, currSum, target);
    }

    // This method calls the recursive helper for three times: Inclusion of single, Inclusion of multiple and 
    // Exclusion of the current element - Shradha's approach, This approach uses HashSet to avoid duplicates
    // This approach is not optimal as it uses extra space for HashSet and also calls the recursive function
    // three times for each element, which increases the time complexity.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        findAllCombSums(candidates, 0, ans, new ArrayList<>(), target, set);
        return ans;
    }

    private void findAllCombSums(int[] arr, int i, List<List<Integer>> ans, List<Integer> currSum, int target, Set<List<Integer>> set){
        if(i == arr.length || target < 0) return;

        if(target == 0){
            if(!set.contains(currSum)){
                set.add(new ArrayList<>(currSum));
                ans.add(new ArrayList<>(currSum));
                return;
            }
        }

        //Inclusion Single
        currSum.add(arr[i]);
        findAllCombSums(arr, i+1, ans, currSum, target-arr[i], set);

        //Inclusion multiple
        findAllCombSums(arr, i, ans, currSum, target-arr[i], set);
        currSum.remove(currSum.size()-1);

        //Exclusion
        findAllCombSums(arr, i+1, ans, currSum, target, set);
    }


    // 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking with an empty list, full target remaining, and starting at index 0
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentComb, int[] candidates, int remain, int start) {
        // Base Case 1: We overshot the target. Stop exploring this path.
        if (remain < 0) {
            return; 
        }
        
        // Base Case 2: We hit the exact target! Add a COPY of the current combination to results.
        if (remain == 0) {
            result.add(new ArrayList<>(currentComb));
            return;
        }
        
        // Explore choices starting from the 'start' index to prevent duplicate permutations
        for (int i = start; i < candidates.length; i++) {
            // 1. Choose the number
            currentComb.add(candidates[i]);
            
            // 2. Explore further. 
            // Notice we pass 'i' as the start index, NOT 'i + 1'. 
            // This is the magic that allows us to reuse the exact same number!
            backtrack(result, currentComb, candidates, remain - candidates[i], i);
            
            // 3. Un-choose the number (Backtrack) to explore the next option in the loop
            currentComb.remove(currentComb.size() - 1); 
        }
    }
}
