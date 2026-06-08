import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCountofNumsWhichAreNotSpecial {
    public int nonSpecialCount(int l, int r) {
        int total = r - l + 1;
        int limit = (int) Math.sqrt(r);
        List<Integer> primes = sieve(limit);

        int specialCount = 0;
        for (int p : primes) {
            int sq = p * p;
            if (sq >= l && sq <= r) {
                specialCount++;
            }
        }

        return total - specialCount;
    }

    private List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        return primes;
    }
}
