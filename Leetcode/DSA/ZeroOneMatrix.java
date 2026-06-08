public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    q.add(new int[] { i, j });
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length) {
                    if (result[nr][nc] > result[r][c] + 1) {
                        result[nr][nc] = result[r][c] + 1;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }

        return result;
    }
}
