//HASHMAP SOLUTION
class TwoSumMap{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){ //Search remaining in the hashtable
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; //No Solution Found
    }
}

//NORMAL SOLUTION BRUTEFORCE
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] newArr = new int[2];
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[i]+nums[j] == target){
//                     newArr[0] = i;
//                     newArr[1] = j;
//                 }
//             }
//         }
//         return newArr;
//     }
// }