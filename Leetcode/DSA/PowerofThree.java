public class PowerofThree {
    public boolean isPowerOfThree(int n) {

        for (int i = 0;; i++) {
            if (Math.pow(3, i) == n)
                return true;
            else if (Math.pow(3, i) > n)
                return false;
        }
    }
}
