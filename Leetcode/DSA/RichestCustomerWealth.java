public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxW = 0;
        int sum = 0;

        for (int[] cus : accounts) {
            sum = 0;

            for (int bal : cus) {
                sum += bal;
                maxW = Math.max(maxW, sum);
            }
        }

        return maxW;
    }
}

// for(int i=0; i<accounts.length; i++){
    // for(int j=0; j<accounts[i].length; j++){
        // sum += accounts[i][j];