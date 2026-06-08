public class MinimumDeletionstoMakeArrayDivisible {
    public int minOperations(int[] nums, int[] numsDivide) {
        // 1. Find the GCD of the entire numsDivide array
        int gcdVal = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gcdVal = findGCD(gcdVal, numsDivide[i]);
        }
        
        // 2. Sort the nums array to easily find the smallest valid element
        Arrays.sort(nums);
        
        // 3. Find the first element in nums that divides the GCD
        for (int i = 0; i < nums.length; i++) {
            if (gcdVal % nums[i] == 0) {
                // Since the array is sorted, 'i' represents exactly how many 
                // elements we had to skip (delete) to get here!
                return i;
            }
        }
        
        // If no element divides the GCD, it's impossible
        return -1;
    }
    
    // Standard Euclidean Algorithm to find the Greatest Common Divisor
    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
