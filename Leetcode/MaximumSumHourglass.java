public class MaximumSumHourglass {
    public int maxSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxSum = Integer.MIN_VALUE;

        if (rows < 3 || cols < 3) {
            return -1;
        }

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int currentSum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]      //Top 3 elements
                        + grid[i + 1][j + 1] +                                     //Mid 1 element
                        grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];  //Bottom 3 elements

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}
