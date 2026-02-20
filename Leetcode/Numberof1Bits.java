public class Numberof1Bits {
    public int hammingWeight(int n) {
        String digits = Integer.toBinaryString(n);
        int count = 0;
        for (char digit : digits.toCharArray()) {
            if (digit == '1') {
                count++;
            }
        }
        return count;
    }
}