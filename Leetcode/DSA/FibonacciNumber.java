public class FibonacciNumber {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int fib(int n) {
        if(n <= 0)
            return 0;

        if(n == 1)
            return 1;
        
        int[] result = new int[n+1];
        
        result[0] = 0;
        result[1] = 1;
        for(int i=2; i<=n; i++){
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int fib(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, c = -1;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
