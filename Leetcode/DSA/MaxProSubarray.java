class MaxProSubarray {
    public int maxProduct(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];
        
        for (int i=0; i<nums.length; i++){
            //if any of leftProduct and rightProduct become 0 then update it to 1.
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            //prefix product
            leftProduct *= nums[i];
            //suffix product
            rightProduct *= nums[nums.length-1-i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return ans;
    }
}