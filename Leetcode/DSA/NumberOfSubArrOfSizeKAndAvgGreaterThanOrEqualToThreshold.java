class NumberOfSubArrOfSizeKAndAvgGreaterThanOrEqualToThreshold {
    // Sliding Window with Sum Calculation
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int l = 0;
        int sum = 0;
        int maxT = k * threshold;

        for(int r=0; r<arr.length; r++){
            sum += arr[r];

            if(r-l+1 == k){
                if(sum >= maxT)
                    count++;

                sum -= arr[l];
                l++;
            }
        }

        return count;
    }

    // Sliding Window with Average Calculation
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0;
        int count = 0;
        int sum = 0;

        for(int r=0; r<arr.length; r++){
            sum += arr[r];

            if(r-l+1 == k){
                int avg = sum/k;
                if(avg >= threshold){
                    count++;
                }
                sum -= arr[l];
                l++;
            }
        }

        return count;
    }
}