public class MyPow {

    //Recursion Approach
    public double myPow(double x, int n) {
        long longN = n;
        if (longN < 0) {
            x = 1 / x;
            longN = -longN;
        }
        return fastPow(x, longN);
    }
    
    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    
    //Iterative Approach
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
