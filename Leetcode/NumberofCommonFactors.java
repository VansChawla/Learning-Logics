class NumberofCommonFactors {
    public int commonFactors(int a, int b) {
        int count = 0;
        int c = a > b ? b : a;

        for(int i=1; i<=c; i++){
            if(a%i==0 && b%i==0){
                count++;
            }
        }

        return count;
    }
}