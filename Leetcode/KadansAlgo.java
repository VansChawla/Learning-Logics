public class KadansAlgo {
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE; //maxsum
        int cs = 0; //currentsum
        
        for (int i=0; i<nums.length; i++){
            cs = cs + nums[i];
            ms = Math.max(cs,ms);
            if(cs<0){
                cs=0;
            }
        }
        return ms;
    }
}