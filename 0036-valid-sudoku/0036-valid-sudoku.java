class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i < board.length;i++){
            for(int j = 0; j < board[1].length;j++){
                if(board[i][j] == '.')
                    continue;
                else{
                    if(!isValidNo(board[i][j],j,i,board))
                        return false;
                }
            }
        }

        return true;

    }

    public boolean isValidNo(char digit,int col,int row,char board[][]){
        //check in row
        for(int i = 0;i < board[0].length;i++){
            if(i == col)
                continue;
            if(board[row][i] == digit){
                return false;
            }
        }
        //check in column
        for(int j = 0;j < board.length;j++){
            if(j == row)
                continue;
            if(board[j][col] == digit)
                return false;
        }
        //check in sub grid by dividing row and column by 3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3)*3;

        for(int i = startRow;i < startRow + 3;i++){
            for(int j = startCol;j < startCol + 3;j++){
                if(i == row && j == col)
                    continue;
                if(board[i][j] == digit)
                    return false;
            }
        }

        return true;
    }
}