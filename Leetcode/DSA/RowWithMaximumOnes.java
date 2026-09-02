class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        int oneCount = 0;
        int maxCount = Integer.MIN_VALUE;

        for(int i=0; i<mat.length; i++){
            oneCount = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1) oneCount++;
            }
            if(oneCount > maxCount && oneCount != maxCount){
                ans[0] = i;
                maxCount = oneCount;
                ans[1] = maxCount;
            }
            // OR
            // if(oneCount > maxCount && oneCount != maxCount){
            //     ans[0] = i;
            // }
            // maxCount = Math.max(maxCount, oneCount);
            // ans[1] = maxCount;
        }

        return ans;
    }
}