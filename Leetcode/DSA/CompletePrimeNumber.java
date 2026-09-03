class CompletePrimeNumber {
    public boolean completePrime(int num) {
        if (num <= 1) return false;

        List<Integer> list = new ArrayList<>();

        //Prefixes
        int temp = num;
        while(temp > 0){
            list.add(temp);
            temp /= 10;
        }

        //Suffixes
        int divisor = 10;
        while (divisor < num) {
            list.add(num % divisor);
            divisor *= 10;
        }

        for(int i=0; i<list.size(); i++){
            if(!isPrime(list.get(i)))
                return false;
        }

        return true;
    }
    private boolean isPrime(int num){
        if(num <= 1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}