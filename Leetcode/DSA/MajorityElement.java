import java.util.HashMap;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }
            else {
                count--;
            }
        }
    return candidate;
    }

    //HASHMAP SOLUTION - O(N)
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            // if(map.containsKey(nums[i]){
            //     map.put(nums[i], map.get(nums[i]) + 1);
            // } else {
            //     map.put(nums[i], 1);
            // }
            //OR
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        // Set<Integer> keySet = map.keySet();
        // for(Integer key : keySet){
        //OR
        for(Integer key : map.keySet()){
            if(map.get(key) > nums.length/2){
                ans = key;
            }
        }

        return ans;
    }
}