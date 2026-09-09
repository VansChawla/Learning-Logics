class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int maxArea = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int currArea = dfs(grid, vis, i, j);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length; int n = grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0 || vis[i][j]) return 0;

        vis[i][j] = true;

        int area = 1;
        area += dfs(grid, vis, i - 1, j); // Up
        area += dfs(grid, vis, i + 1, j); // Down
        area += dfs(grid, vis, i, j - 1); // Left
        area += dfs(grid, vis, i, j + 1); // Right

        return area;
    }
}