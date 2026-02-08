class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num; 
        }
        
        return result;
    }
}

// BRUTE FORCE APPROACH -O(N) & O(N)
// class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int num : nums){
//             if(map.containsKey(num)){
//                 int currentCount = map.get(num);
//                 map.put(num, currentCount+1);
//             } else {
//                 map.put(num, 1);
//             }
//         }

//         int result = 0;
//         for(int key : map.keySet()){
//             if(map.get(key) == 1){
//                 result = key;
//             }
//         }

//         return result;
//     }
// }