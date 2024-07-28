class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = '.';
            }
        }
        NQueen(result,board,0);
        return result;

    }

    private void NQueen(List<List<String>> result,char[][] board,int row){
        //base case
        if(row == board.length){
            result.add(twoDArrayToList(board));
            return;
        }

        //recursion case
        for(int j = 0;j < board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                NQueen(result,board,row+1);
                board[row][j] = '.';
            }
        }
    }

    private boolean isSafe(char board[][],int row,int col){
        //checking vertical up
        for(int i = row-1;i >= 0;i--){
            if(board[i][col] == 'Q')
                return false;
        }

        //checking left diagonal
        for(int i = row-1,j = col-1; i >= 0 && j >= 0;i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }

        //checking right diagonal
        for(int i = row-1,j = col+1; i >= 0 && j < board.length;i--,j++){
            if(board[i][j] == 'Q')
                return false;
        }      
        return true;
    }
    private List<String> twoDArrayToList(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < board.length;i++){
            temp.add(new String(board[i]));
        }
        return temp;
    }
}