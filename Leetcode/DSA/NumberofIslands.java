class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    // bfs(grid, vis, i, j);
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    //DFS
    private void dfs(char[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length, n = grid[0].length;
        vis[i][j] = true;

        if(i>0 && grid[i-1][j] == '1' && !vis[i-1][j])
            dfs(grid, vis, i-1, j);
        if(i+1<m && grid[i+1][j] == '1' && !vis[i+1][j])
            dfs(grid, vis, i+1, j);
        if(j>0 && grid[i][j-1] == '1' && !vis[i][j-1])
            dfs(grid, vis, i, j-1);
        if(j+1<n && grid[i][j+1] == '1' && !vis[i][j+1])
            dfs(grid, vis, i, j+1);
    }

    //BFS
    private void bfs(char[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        vis[i][j] = true;
        q.add(new Pair(i, j));
        while(!q.isEmpty()){
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;

            //Top
            if(row>0){
                if(grid[row-1][col] == '1' && !vis[row-1][col]){
                    q.add(new Pair(row-1, col));
                    vis[row-1][col] = true;
                }
            }

            //Bottom
            if(row+1<m){
                if(grid[row+1][col] == '1' && !vis[row+1][col]){
                    q.add(new Pair(row+1, col));
                    vis[row+1][col] = true;
                }
            }

            //Left
            if(col>0){
                if(grid[row][col-1] == '1' && !vis[row][col-1]){
                    q.add(new Pair(row, col-1));
                    vis[row][col-1] = true;
                }
            }

            //Right
            if(col+1<n){
                if(grid[row][col+1] == '1' && !vis[row][col+1]){
                    q.add(new Pair(row, col+1));
                    vis[row][col+1] = true;
                }
            }
        }
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}