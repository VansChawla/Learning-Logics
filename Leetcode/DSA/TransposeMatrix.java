public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int answer[][] = new int[m][n];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[i].length; j++){
                answer[i][j] = matrix[j][i];
            }
        }

        return answer;
    }
}