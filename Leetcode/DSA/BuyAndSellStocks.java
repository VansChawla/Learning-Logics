public class BuyAndSellStocks {
    //Striver's Solution
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            int cost = prices[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, prices[i]); //Keeping track of min price of the stock on previous days
        }

        return maxProfit;
    }

    
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
