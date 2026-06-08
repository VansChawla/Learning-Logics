class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        } 
        
        int maxLength = 0;
        for(int num : numSet){
            if(!numSet.contains(num - 1)){
                int currNum = num;
                int currLength = 1;

                while(numSet.contains(currNum + 1)){
                    currNum++;
                    currLength++;
                }
                
                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}