class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long nSquared = (long) n * n;
        
        // Calculate expected sums using standard math formulas
        long expectedSum = nSquared * (nSquared + 1) / 2;
        long expectedSumSquares = nSquared * (nSquared + 1) * (2 * nSquared + 1) / 6;
        
        long actualSum = 0;
        long actualSumSquares = 0;
        
        // Traverse grid to find actual sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                actualSum += val;
                actualSumSquares += val * val;
            }
        }
        
        // Diff1 = R - M
        long diff1 = actualSum - expectedSum; 
        
        // Diff2 = R^2 - M^2
        long diff2 = actualSumSquares - expectedSumSquares; 
        
        // sumRM = R + M = (R^2 - M^2) / (R - M)
        long sumRM = diff2 / diff1; 
        
        // Solve the system of equations
        int repeated = (int) ((diff1 + sumRM) / 2);
        int missing = (int) (repeated - diff1);
        
        return new int[]{repeated, missing};
    }
}
