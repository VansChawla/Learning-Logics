public class DifferencebetwElementSumAndDigitSumofArray {
    public int differenceOfSum(int[] nums) {
        int eleSum = 0;
        int digSum = 0;
        for (int i = 0; i < nums.length; i++) {
            eleSum += nums[i]; // element sum

            while (nums[i] > 0) { // digit sum
                digSum += nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return eleSum - digSum;
    }
}
