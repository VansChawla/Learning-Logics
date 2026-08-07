import java.util.ArrayList;

class KnightTour {
    //GFG Problem: Knight's Tour Problem
    public boolean helper(ArrayList<ArrayList<Integer>> res, int i, int j, int steps, int n) {
        if (steps == n * n - 1) {
            res.get(i).set(j, n * n - 1);
            return true;
        }
        
        res.get(i).set(j, steps);
        
        if ((i + 2 < n) && (j + 1 < n) && (res.get(i + 2).get(j + 1) == -1) && helper(res, i + 2, j + 1, steps + 1, n)) {
            return true;
        }
        if ((i + 1 < n) && (j + 2 < n) && (res.get(i + 1).get(j + 2) == -1) && helper(res, i + 1, j + 2, steps + 1, n)) {
            return true;
        }
        if ((i - 2 >= 0) && (j + 1 < n) && (res.get(i - 2).get(j + 1) == -1) && helper(res, i - 2, j + 1, steps + 1, n)) {
            return true;
        }
        if ((i - 1 >= 0) && (j + 2 < n) && (res.get(i - 1).get(j + 2) == -1) && helper(res, i - 1, j + 2, steps + 1, n)) {
            return true;
        }
        if ((i - 2 >= 0) && (j - 1 >= 0) && (res.get(i - 2).get(j - 1) == -1) && helper(res, i - 2, j - 1, steps + 1, n)) {
            return true;
        }
        if ((i - 1 >= 0) && (j - 2 >= 0) && (res.get(i - 1).get(j - 2) == -1) && helper(res, i - 1, j - 2, steps + 1, n)) {
            return true;
        }
        if ((i + 2 < n) && (j - 1 >= 0) && (res.get(i + 2).get(j - 1) == -1) && helper(res, i + 2, j - 1, steps + 1, n)) {
            return true;
        }
        if ((i + 1 < n) && (j - 2 >= 0) && (res.get(i + 1).get(j - 2) == -1) && helper(res, i + 1, j - 2, steps + 1, n)) {
            return true;
        }
        
        res.get(i).set(j, -1);
        return false;
    }

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(-1);
            }
            res.add(row);
        }
        
        helper(res, 0, 0, 0, n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res.get(i).get(j) == -1) {
                    return new ArrayList<>(); 
                }
            }
        }
        return res;
    }


    //Leetcode 2596. Check Knight Tour Configuration
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;

        int n = grid.length;
        return helper(grid, 0, 0, 0, n);
    }

    private boolean helper(int[][] res, int i, int j, int steps, int n) {
        if (steps == n * n - 1) {
            return true;
        }
        
        if ((i + 2 < n) && (j + 1 < n) && (res[i + 2][j + 1] == steps+1) && helper(res, i + 2, j + 1, steps + 1, n)) {
            return true;
        }
        if ((i + 1 < n) && (j + 2 < n) && (res[i + 1][j + 2] == steps+1) && helper(res, i + 1, j + 2, steps + 1, n)) {
            return true;
        }
        if ((i - 2 >= 0) && (j + 1 < n) && (res[i - 2][j + 1] == steps+1) && helper(res, i - 2, j + 1, steps + 1, n)) {
            return true;
        }
        if ((i - 1 >= 0) && (j + 2 < n) && (res[i - 1][j + 2] == steps+1) && helper(res, i - 1, j + 2, steps + 1, n)) {
            return true;
        }
        if ((i - 2 >= 0) && (j - 1 >= 0) && (res[i - 2][j - 1] == steps+1) && helper(res, i - 2, j - 1, steps + 1, n)) {
            return true;
        }
        if ((i - 1 >= 0) && (j - 2 >= 0) && (res[i - 1][j - 2] == steps+1) && helper(res, i - 1, j - 2, steps + 1, n)) {
            return true;
        }
        if ((i + 2 < n) && (j - 1 >= 0) && (res[i + 2][j - 1] == steps+1) && helper(res, i + 2, j - 1, steps + 1, n)) {
            return true;
        }
        if ((i + 1 < n) && (j - 2 >= 0) && (res[i + 1][j - 2] == steps+1) && helper(res, i + 1, j - 2, steps + 1, n)) {
            return true;
        }
        
        res[i][j] = -1;
        return false;
    }
}
