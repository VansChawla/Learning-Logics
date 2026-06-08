import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

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
