class SetMatrixZeroess {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // int row[n] = matrix[][0];
        // int col[m] = matrix[0][];
        //Keeping ready row and col in the matrix itself
        int col0 = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        //Then do conversion on whole matrix excluding first col and row
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] != 0){
                    if(matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //Here, convert first row because it is dependent on first col
        if(matrix[0][0] == 0){
            for(int j=0; j<m; j++) matrix[0][j] = 0;
        }
        //Lastly, convert first col
        if(col0 == 0){
            for(int i=0; i<n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}