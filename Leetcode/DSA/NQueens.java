import java.util.*;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        
        nQueens(0, chessBoard, result);

        return result;
    }

    private void nQueens(int row, char[][] chessBoard, List<List<String>> result) {
        int n = chessBoard.length;
        
        if (row == n) { 
            result.add(constructBoard(chessBoard));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (canQueenBePlaced(row, col, chessBoard)) {
                chessBoard[row][col] = 'Q'; // mark
                nQueens(row + 1, chessBoard, result);
                chessBoard[row][col] = '.'; // unmark (backtracking)
            }
        }
    }

    // Convert char[][] to List<String>
    private List<String> constructBoard(char[][] chessBoard) {
        List<String> boardStr = new ArrayList<>();
        for (int i = 0; i < chessBoard.length; i++) {
            boardStr.add(new String(chessBoard[i]));
        }
        return boardStr;
    }

    private boolean canQueenBePlaced(int row, int col, char[][] chessBoard) {
        int n = chessBoard.length;
        
        // check col / vertically up
        int i = row - 1;
        while (i >= 0) {
            if (chessBoard[i][col] == 'Q') return false;
            i--;
        }
        
        // check left diagonally up
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 'Q') return false;
            i--;
            j--;
        }
        
        // check right diagonally up
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (chessBoard[i][j] == 'Q') return false;
            i--;
            j++;
        }
        
        return true;
    }
}