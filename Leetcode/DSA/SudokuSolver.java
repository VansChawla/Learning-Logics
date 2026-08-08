class SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public boolean helper(char[][] sudoku, int row, int col) {
        if(row == 9) return true;

        int nextR = row;
        int nextC = col+1;
        if(col+1 == 9){
            nextR = row+1;
            nextC = 0;
        }

        if(sudoku[row][col] != '.'){
            return helper(sudoku, nextR, nextC);
        }

        for(int digit=1; digit<=9; digit++){
            char ch = (char)(digit + '0');
            if(isSafe(sudoku, row, col, ch)){
                sudoku[row][col] = ch;
                if(helper(sudoku, nextR, nextC)){
                    return true;
                }
                sudoku[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] sudoku, int row, int col, char digit){
        for(int i=0; i<=8; i++){
            if(sudoku[i][col] == digit){ //col check
                return false;
            }
        }

        for(int j=0; j<=8; j++){
            if(sudoku[row][j] == digit){ //row check
                return false;
            }
        }

        int startingR = (row / 3) * 3;  //internal 3x3 square check
        int startingC = (col / 3) * 3;

        for(int i=startingR; i<startingR+3; i++){
            for(int j=startingC; j<startingC+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
}