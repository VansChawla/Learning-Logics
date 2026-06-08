class ContainerMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.length-1;

        while(lp < rp){
            maxWater = Math.max(maxWater, Math.min(height[lp], height[rp]) * (rp-lp));
            if(height[lp]<height[rp]) lp++;
            else rp--;
        }
        return maxWater;
    }
}