public class ShuffletheArray {
    public int[] shuffle(int[] nums, int n) {
        //optimized solution
        int[] array=new int[2*n];
        for (int i=0;i<n;i++){
            array[2*i]=nums[i];
            array[2*i+1]=nums[n+i];
        }
        return array;

        //brute force solution
        int[] result = new int[2 * n];

        int l = 0, m = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                result[i] = nums[l];
                l++;
            } else {
                result[i] = nums[m];
                m++;
            }
        }
        return result;
    }
}
