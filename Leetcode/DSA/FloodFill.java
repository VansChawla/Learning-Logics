public class FloodFill {
    //New Solution
    private void helper(int[][] image, int sr, int sc, int color, int orgColor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] != orgColor)
            return;
        
        image[sr][sc] = color;

        helper(image, sr, sc-1, color, orgColor); //left
        helper(image, sr, sc+1, color, orgColor); //right
        helper(image, sr-1, sc, color, orgColor); //up
        helper(image, sr+1, sc, color, orgColor); //down
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        
        if (orgColor != color)
            helper(image, sr, sc, color, orgColor);
        return image;
    }


    //Old Solution
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     int startingColor = image[sr][sc];

    //     if (startingColor != color)
    //         dfs(image, sr, sc, startingColor, color);

    //     return image;
    // }

    // private static void dfs(int image[][], int r, int c, int startingColor, int newColor) {
    //     if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startingColor)
    //         return;

    //     image[r][c] = newColor;

    //     dfs(image, r + 1, c, startingColor, newColor);
    //     dfs(image, r - 1, c, startingColor, newColor);
    //     dfs(image, r, c + 1, startingColor, newColor);
    //     dfs(image, r, c - 1, startingColor, newColor);
    // }
}
