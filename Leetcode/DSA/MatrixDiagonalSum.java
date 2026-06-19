public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        if(mat.length == 1) return mat[0][0];

        int firstDiaSum = 0;
        int secondDiaSum = 0;
        for(int i=0; i<mat.length; i++){
            firstDiaSum += mat[i][i];
            secondDiaSum += mat[i][mat.length-1-i];
        }

        int answer = firstDiaSum + secondDiaSum;
        if(mat.length % 2 != 0){
            int n = mat.length/2;
            answer = answer - mat[n][n];
        }

        return answer;
    }
}