public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        calculcatePrefixSum(mat);

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min((int) n - 1, i + k);
                int c2 = Math.min((int) m - 1, j + k);
                ans[i][j] = sumRegion(mat, r1, c1, r2, c2);
            }
        }

        return ans;
    }

    private void calculcatePrefixSum(int[][] psum) {
        int n = psum.length;
        int m = psum[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                psum[i][j] += psum[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                psum[j][i] += psum[j - 1][i];
            }
        }
    }

    private int sumRegion(int[][] psum, int r1, int c1, int r2, int c2) {
        int ans = psum[r2][c2];
        if (r1 > 0)
            ans -= psum[r1 - 1][c2];
        if (c1 > 0)
            ans -= psum[r2][c1 - 1];
        if (r1 > 0 && c1 > 0)
            ans += psum[r1 - 1][c1 - 1];
        return ans;
    }
}
