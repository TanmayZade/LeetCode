class Solution {
    public void solveSudoku(char[][] board) {
       boolean soln = SudokuSolver(board,0,0);
        return;
    }

    public boolean SudokuSolver(char[][] sudoku,int row,int col){
        //base case
        if(row == 9)
            return true;

        //recursion case
        //if columns of particular rows are completed
        if(col == 9){
            return SudokuSolver(sudoku,row+1,0);
        }
        if(sudoku[row][col] != '.')
            return SudokuSolver(sudoku,row,col+1);

        for(char digit = '1'; digit <= '9';digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
            if(SudokuSolver(sudoku,row,col+1))
                return true;
            sudoku[row][col] = '.';
            }

        }
        return false;
    }

    //checking if digit is safe to place in board
    public static boolean isSafe(char sudoku[][],int row,int col,char digit){
        //checking if same digit is present in current col
        for(int i = 0;i < 9;i++){
            if(sudoku[i][col] == digit)
                return false;
        }

        //checking if same digit is present in current row
        for(int j = 0; j< 9;j++){
            if(sudoku[row][j] == digit)
                return false;
        }

        //checking if digit is present in sub-grid or not
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i = sr;i < sr+3;i++){
            for(int j = sc; j < sc+3; j++){
                if(sudoku[i][j] == digit)
                    return false;
            }
        }

        return true;
    }
}