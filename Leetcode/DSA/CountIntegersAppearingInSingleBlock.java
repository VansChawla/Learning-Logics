class CountIntegersAppearingInSingleBlock {
    public int countSpecialIntegers(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> invalid = new HashSet<>();
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        
        visited.add(nums[0]);
        uniqueNumbers.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            uniqueNumbers.add(nums[i]);
            
            if (nums[i] != nums[i - 1]) {
                if (visited.contains(nums[i])) {
                    invalid.add(nums[i]);
                }
                visited.add(nums[i]);
            }
        }
        
        return uniqueNumbers.size() - invalid.size();
    }
}
