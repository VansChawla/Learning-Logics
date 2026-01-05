public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        long N = n;
        double result = 1.0;
        double currentX = x;

        if (N < 0) {
            currentX = 1 / currentX;
            N = -N;
        }

        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentX;
            }

            currentX *= currentX;
            N /= 2;
        }

        return result;
    }
}
