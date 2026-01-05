public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {

        for (int i=0 ;; i++) {
            if (Math.pow(2, i) == n)
                return true;
            else if (Math.pow(2, i) > n)
                return false;
        }
    }
}
