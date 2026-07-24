import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //Striver's optimized approach using Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int ele1 = 0;
        int count2 = 0;
        int ele2 = 0;

        for(int i=0; i<nums.length; i++){
            if(count1 == 0 && nums[i] != ele2){
                count1 = 1;
                ele1 = nums[i];
            } else if(count2 == 0 && nums[i] != ele1){
                count2 = 1;
                ele2 = nums[i];
            } else if(ele1 == nums[i]){
                count1++;
            } else if(ele2 == nums[i]){
                count2++;
            } else {
                count1--; count2--;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        count1 = 0; count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(ele1 == nums[i]) count1++;
            if(ele2 == nums[i]) count2++;
        }

        int min = (int) (nums.length/3) + 1;
        if(count1 >= min) list.add(ele1);
        if(count2 >= min && ele1 != ele2) list.add(ele2);
        Collections.sort(list);

        return list;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : map.keySet()){
            if(map.get(key) > nums.length/3){
                ans.add(key);
            }
        }
        return ans;
    }
}