import java.util.Arrays;

public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        //---Optimized---
        int res = 0;
        
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i%2 == 0) {
              res += nums[i];
            }
        }

        return res;

        //---Bruteforce---
        Arrays.sort(nums);

        int result = 0;
        for(int i=0; i<nums.length; i+=2){
            result += Math.min(nums[i], nums[i+1]);
        }

        return result;
    }
}
