class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] directions = {0, 1, 0, -1, 0};

        int currentRow = 0;
        int currentCol = 0;
        int directionIndex = 0; // 0=right, 1=down, 2=left, 3=up

        List<Integer> result = new ArrayList<>();
      
        boolean[][] visited = new boolean[n][m];

        int totalCells = n * m;

        for (int count = 0; count < totalCells; count++) {
            result.add(matrix[currentRow][currentCol]);
          
            visited[currentRow][currentCol] = true;
          
            int nextRow = currentRow + directions[directionIndex];
            int nextCol = currentCol + directions[directionIndex + 1];
          
            if (nextRow < 0 || nextRow >= n || 
                nextCol < 0 || nextCol >= m || 
                visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
          
            currentRow += directions[directionIndex];
            currentCol += directions[directionIndex + 1];
        }
      
        return result;
    }
}