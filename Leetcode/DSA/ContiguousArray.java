import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>(); //sum, pos
        map.put(0, -1);

        int sum = 0;
        int ans = 0;

        for(int j=0; j<nums.length; j++){
            sum += nums[j];
            if(map.containsKey(sum)){
                ans = Math.max(ans, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        return ans;
    }
}