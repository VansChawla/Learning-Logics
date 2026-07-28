class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findUniqueCombSums(candidates, 0, ans, new ArrayList<>(), target);
        return ans;
    }

    private void findUniqueCombSums(int[] arr, int i, List<List<Integer>> ans, List<Integer> currComb, int target){
        if (target < 0) {
            return; 
        }
        
        if (target == 0) {
            ans.add(new ArrayList<>(currComb));
            return;
        }

        for(int idx = i; idx<arr.length; idx++){
            if(idx > i && arr[idx] == arr[idx-1]) continue;

            currComb.add(arr[idx]);
            findUniqueCombSums(arr, idx+1, ans, currComb, target-arr[idx]);
            currComb.remove(currComb.size()-1);
        }
    }
}