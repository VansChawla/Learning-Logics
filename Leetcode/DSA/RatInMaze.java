class RatInMaze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        if (n == 0 || maze[0][0] == 0 || maze[n-1][n-1] == 0) return ans;
        boolean[][] vis = new boolean[n][n];
        helper(0, 0, n-1, n-1, "", maze,vis, ans);
        return ans;
    }
    
    private void helper(int r, int c, int er, int ec, String str, int[][] maze, boolean[][] vis, ArrayList<String> ans){
        if(r<0 || c<0 || r>er || c>ec || vis[r][c] || maze[r][c] == 0) return;
        
        vis[r][c] = true;
            
        if(r == er && c == ec){
            ans.add(str);
            vis[r][c] = false;
            return;
        }
        
        helper(r+1, c, er, ec, str+"D", maze, vis, ans);
        helper(r, c-1, er, ec, str+"L", maze, vis, ans);
        helper(r, c+1, er, ec, str+"R", maze, vis, ans);
        helper(r-1, c, er, ec, str+"U", maze, vis, ans);
        vis[r][c] = false;
    }
}