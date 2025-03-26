class Solution {
    static void dfs(int row,int col,boolean vis[][],char mat[][],int delRow[],int delCol[]){
        int m = mat.length;
        int n = mat[0].length;
        vis[row][col] = true;

        for(int i = 0;i < 4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && vis[nRow][nCol] == false && mat[nRow][nCol] == 'O')
                dfs(nRow, nCol, vis, mat, delRow, delCol);
        }
    }
    public void solve(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int delRow[] = {-1,1,0,0};
        int delCol[] = {0,0,-1,1};
        boolean[][] vis = new boolean[m][n];

        //traversing through boundaries
        //first row and last row
        for(int i = 0;i < n;i++){
            if(vis[0][i] == false && mat[0][i] == 'O')
                dfs(0, i, vis, mat, delRow, delCol);

            if(vis[m-1][i] == false && mat[m-1][i] == 'O')
                dfs(m-1, i, vis, mat, delRow, delCol);
        }
        //first column and last column
        for(int i = 0;i < m;i++){
            if(vis[i][0] == false && mat[i][0] == 'O')
                dfs(i,0,vis, mat, delRow, delCol);

            if(vis[i][n-1] == false && mat[i][n-1] == 'O')
                dfs(i, n-1, vis, mat, delRow, delCol);
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(vis[i][j] == false && mat[i][j] == 'O')
                    mat[i][j] = 'X';
            }
        }
    }
}