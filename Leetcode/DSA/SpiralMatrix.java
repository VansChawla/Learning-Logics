class SpiralMatrix {
    // Easy and Understandable Approach
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int fr = 0;
        int lr = m-1;
        int fc = 0;
        int lc = n-1;
        List<Integer> list = new ArrayList<>();

        while(fr <= lr && fc <= lc){
            for(int i=fc; i<=lc; i++){
                list.add(matrix[fr][i]);
            }
            fr++;
            if(fr>lr || fc>lc) break;

            for(int i=fr; i<=lr; i++){
                list.add(matrix[i][lc]);
            }
            lc--;
            if(fr>lr || fc>lc) break;

            for(int i=lc; i>=fc; i--){
                list.add(matrix[lr][i]);
            }
            lr--;
            if(fr>lr || fc>lc) break;
            
            for(int i=lr; i>=fr; i--){
                list.add(matrix[i][fc]);
            }
            fc++;
        }

        return list;
    }

    // Directional Approach
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