public class RangeSumQueryImmutable {
    class NumArray {
        int[] arr;

        public NumArray(int[] nums) {
            arr = new int[nums.length + 1]; 
            
            int currentSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];
                arr[i + 1] = currentSum;
            }
        }
        
        public int sumRange(int left, int right) {
            return arr[right + 1] - arr[left];
        }
    }
}
