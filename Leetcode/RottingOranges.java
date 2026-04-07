public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 1. Setup: Find all initially rotten oranges and count the fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    // Store coordinates as an array [row, col]
                    queue.offer(new int[] { r, c });
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges to begin with, the answer is 0 minutes
        if (freshCount == 0)
            return 0;

        int minutes = 0;
        // Helper array to easily check up, down, left, right
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // 2. Multi-source BFS
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();

            // Process an entire level (one minute of spreading)
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                // Check all 4 adjacent cells
                for (int[] dir : directions) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];

                    // If out of bounds or NOT a fresh orange, skip it
                    if (nextRow < 0 || nextRow >= rows ||
                            nextCol < 0 || nextCol >= cols ||
                            grid[nextRow][nextCol] != 1) {
                        continue;
                    }

                    // Rot the fresh orange!
                    grid[nextRow][nextCol] = 2;
                    freshCount--; // We have one less fresh orange

                    // Add it to the queue so it can spread rot in the next minute
                    queue.offer(new int[] { nextRow, nextCol });
                }
            }
            // A full minute has passed
            minutes++;
        }

        // 3. Did we rot everything?
        return freshCount == 0 ? minutes : -1;
    }
}
