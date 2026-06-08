public class ReverseBits {
    public int reverseBits(int n) {
        String num = Integer.toBinaryString(n);
        while (num.length() < 32)
            num = "0" + num;
        char[] numArray = num.toCharArray();

        int i = 0;
        int j = numArray.length - 1;
        while (i < j) {
            char temp = numArray[i];
            numArray[i] = numArray[j];
            numArray[j] = temp;
            i++;
            j--;
        }

        String joined = new String(numArray);

        int res = Integer.parseUnsignedInt(joined, 2);
        return res;
    }
}
