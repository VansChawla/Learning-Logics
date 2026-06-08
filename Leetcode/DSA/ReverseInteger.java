public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int dgt = x % 10;
            res = (res * 10) + dgt;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }
}
