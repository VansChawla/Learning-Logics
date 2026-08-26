class MinTotalPriceAfterApplyingDiscounts {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = prices.length-1;
        int j = discounts.length-1;

        double finalPrice = 0.0;
        while(i >= 0 || j >= 0){
            if(j<0){
                finalPrice += (prices[i] * (100.0 - 0.0)) / 100.0;
            } else if (i<0) {
                finalPrice += (0.0 * (100.0 - discounts[j])) / 100.0;
            } else {
                finalPrice += (prices[i] * (100.0 - discounts[j])) / 100.0;
            }
            i--; j--;
        }

        return finalPrice;
    }
}