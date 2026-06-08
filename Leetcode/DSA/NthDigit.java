public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        int startNumber = start + (n - 1) / len;
        String s = Integer.toString(startNumber);
        int indexInsideNumber = (n - 1) % len;

        return s.charAt(indexInsideNumber) - '0';
    }
}
