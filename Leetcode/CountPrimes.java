class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i * i < n; i++) {
            if (notPrime[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        
        // Count the remaining primes
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
            }
        }
        
        return count;
    }
}

// ----TIME COMPLEXITY EXCEEDED FOR THIS BELOW CODE----
// class Solution {
//     public int countPrimes(int n) {
//         if(n == 0 || n == 1) return 0;
//         int count = 0;

//         for(int i=2; i<n; i++){
//             if(isPrime(i)){
//                count++;
//             }
//         }
//         return count;
//     }

//     public boolean isPrime(int num){
//         for(int i=2; i<=Math.sqrt(num); i++){
//             if(num%i == 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
