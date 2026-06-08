import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        if (n == 1)
            return 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });
        grid[0][0] = 1;

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 } };

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    if (nr == n - 1 && nc == n - 1) {
                        return dist + 1;
                    }
                    grid[nr][nc] = 1; // Mark as visited
                    q.add(new int[] { nr, nc, dist + 1 });
                }
            }
        }

        return -1;
    }
}
