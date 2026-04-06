public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];

        if (startingColor != color)
            dfs(image, sr, sc, startingColor, color);

        return image;
    }

    private static void dfs(int image[][], int r, int c, int startingColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startingColor)
            return;

        image[r][c] = newColor;

        dfs(image, r + 1, c, startingColor, newColor);
        dfs(image, r - 1, c, startingColor, newColor);
        dfs(image, r, c + 1, startingColor, newColor);
        dfs(image, r, c - 1, startingColor, newColor);
    }
}
