class RotateImage {
    public void rotate(int[][] matrix) {
        //Transpose
        for(int i=0; i<matrix.length-1; i++){
            for(int j=i+1; j<matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reversing each row
        for(int i=0; i<matrix.length; i++){
            int k = 0, j = matrix[i].length-1;
            while(k < j){
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
                k++; j--;
            }
        }

    }
}